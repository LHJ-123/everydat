package java_0715;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//演示服务器给浏览器写回一个cookie
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //构造cookie对象
        Cookie userName = new Cookie("userName","lhj");
        Cookie age = new Cookie("age",18+"");
        resp.addCookie(userName);
        resp.addCookie(age);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("返回cookie 成功");
    }
}
