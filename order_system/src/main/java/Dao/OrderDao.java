package Dao;


import model.DBUtil;
import model.Dish;
import model.Order;
import util.OrderSystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//新增订单
//查看所有订单
//查看指定用户订单
//查看订单详情
//修改订单状态
public class OrderDao {
    public void add(Order order) throws OrderSystemException, SQLException {
        addOrderUser(order);
        addOrderDish(order);
    }
    private void addOrderUser(Order order) throws OrderSystemException, SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "insert into order_user values(null,?,now(),0)";
            //会自动返回自增主键的值
            preparedStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,order.getUserId());
            int ret = preparedStatement.executeUpdate();
            if (ret != 1) {
                throw  new OrderSystemException("插入订单失败");
            }
            //把自增主键的值读出来
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new OrderSystemException("插入订单失败");
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
    private void addOrderDish(Order order) throws SQLException, OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //关闭自动提交
            connection.setAutoCommit(false);
            String sql = "insert into order_dish values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            List<Dish> dishList = order.getDishes();
            for (Dish dish:dishList) {
                preparedStatement.setInt(1,order.getOrderId());
                preparedStatement.setInt(2,dish.getDishId());
                preparedStatement.addBatch();//给SQL拼接
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            deleteOrderUser(order.getOrderId());
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }
//用于删除order_user表中的记录
    private void deleteOrderUser(int orderId) throws OrderSystemException, SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "delete from order_user where orderId = ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);
            int ret = preparedStatement.executeUpdate();
            if(ret != 1) {
                throw  new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (OrderSystemException e) {
            e.printStackTrace();
            throw  new OrderSystemException("回滚失败");
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }

    }

public List<Order> selectAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
    try {
        String sql = "select * from order_user";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getInt("orderId"));
            order.setUserId(resultSet.getInt("userId"));
            order.setTime(resultSet.getTimestamp("time"));
            order.setIsDone(resultSet.getInt("isDone"));
            orders.add(order);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(connection,preparedStatement,resultSet);
    }
    return orders;
}

public List<Order> selectByUserId(int userId) throws SQLException {
    List<Order> orders = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
    try {
        String sql = "select * from order_user where userId = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getInt("orderId"));
            order.setUserId(resultSet.getInt("userId"));
            order.setTime(resultSet.getTimestamp("time"));
            order.setIsDone(resultSet.getInt("isDone"));
            orders.add(order);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(connection,preparedStatement,resultSet);
    }
    return orders;
}

public Order selectById(int orderId) throws SQLException, OrderSystemException {
        Order order = buildOrder(orderId);
        List<Integer> dishIds = selectDishIds(orderId);
        order = getDishDetail(order,dishIds);
        return order;
}

    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException, SQLException {
        List<Dish> dishes = new ArrayList<>();
        DishDao dishDao = new DishDao();
        for (Integer dishId:dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        order.setDishes(dishes);
        return order;
    }

    private List<Integer> selectDishIds(int orderId) throws SQLException {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_dish where orderId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dishIds.add(resultSet.getInt("dishId"));
            }return dishIds;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return dishIds;
    }

    private Order buildOrder(int orderId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_user where orderId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public void changeState(int orderId,int isDone) throws OrderSystemException, SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update order_user set isDone = ? where orderId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,isDone);
            preparedStatement.setInt(2,orderId);
            int ret = preparedStatement.executeUpdate();
            if(ret != 1) {
                throw new OrderSystemException("修改订单失败");
            }
            System.out.println("修改订单成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (OrderSystemException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单失败");
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }

    }
}
