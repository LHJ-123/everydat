package API;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    //浏览器是通过POST方法提交注册信息给服务器的
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //1.获取前端 提交数据校验是否合法
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(name == null || "".equals(name)
        || password == null || "".equals(password)) {
            //用户提交的数据有误，返回一个错误页面（HTML）
            String html = HtmlGenerator.getMessagePage("用户名或者密码为空","register.html");
            resp.getWriter().write(html);
            return;
        }
        //2.拿用户名在数据库中查看是否存在，存在则注册失败
        UserDao userDao = new UserDao();
        User existUser = userDao.selectByName(name);
        if (existUser != null) {
            String html = HtmlGenerator.getMessagePage("用户名重复，请换一个名字",
                    "register.html");
            resp.getWriter().write(html);
            return;
        }
        //3.根据提交的对象构造user对象并插入到数据库中
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);
        //4.返回一个结果页面，提示注册成功
        System.out.println(user.getName());
       String html = HtmlGenerator.getMessagePage("注册成功,点击跳转到登录页面",
               "login.html");
       resp.getWriter().write(html);
       return;
    }
}
