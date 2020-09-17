package API;

import Dao.OrderDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.Order;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("管理员禁止新增订单");
            }
            String body = OrderSystemUtil.readBody(req);
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            if (dishIds == null || dishIds.length == 0) {
                throw new OrderSystemException("未选菜, 请先选择你喜欢的菜");
            }
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId:dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }

            order.setDishes(dishes);
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException | SQLException e) {
            e.printStackTrace();
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        List<Order> orders = new ArrayList<>();
        try {
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("用户尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户尚未登录");
            }
            String orderIdStr = req.getParameter("orderId");
            OrderDao orderDao = new OrderDao();
            if (orderIdStr == null) {


                if (user.getIsAdmin() == 0) {
                    orders = orderDao.selectByUserId(user.getUserId());
                }else {
                    orders = orderDao.selectAll();
                }
                String jsonString = gson.toJson(orders);
                resp.getWriter().write(jsonString);
            }else {
                int orderId = Integer.parseInt(orderIdStr);
                Order order = orderDao.selectById(orderId);
                if (user.getIsAdmin() == 0&&order.getUserId() != user.getUserId()) {
                    throw new OrderSystemException("当前无权查看其他人订单");
                }
                String jsonString = gson.toJson(order);
                resp.getWriter().write(jsonString);
            }

        } catch (OrderSystemException | SQLException e) {
            e.printStackTrace();
            String jsonString = gson.toJson(orders);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("用户尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户尚未登录");
            }
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            String orderIdStr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if (orderIdStr == null || isDoneStr == null) {
                throw new OrderSystemException("参数有误");
            }
            OrderDao orderDao = new OrderDao();
            int orderId = Integer.parseInt(orderIdStr);
            int isDone = Integer.parseInt(isDoneStr);
            orderDao.changeState(orderId,isDone);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException | SQLException e) {
            e.printStackTrace();
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您当前未登录");
            }
            User user = (User) session.getAttribute("user");
            String orderIdStr = req.getParameter("orderId");
            if (orderIdStr == null) {
                throw new OrderSystemException("参数不正确");
            }
            if (user.getIsAdmin() == 0) {
                //不是管理员
                throw new OrderSystemException("非管理员不可删除订单");
            }

            //找到这个订单查看是否已经完成该订单
            int orderId = Integer.parseInt(orderIdStr);
            OrderDao dao = new OrderDao();
            Order order = dao.findDetailedOrder(orderId);
            if (order == null) {
                throw new OrderSystemException("数据错误");
            }
            if (order.getIsDone() == 0) {
                //该订单还未完成
                throw new OrderSystemException("该订单还未完成");
            }
            dao.deleteOrder(orderId);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException | SQLException e) {
            e.printStackTrace();
            response.ok = 1;
            response.reason = "";
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
