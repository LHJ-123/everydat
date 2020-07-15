package java_0715;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        resp.setContentType("text/html; charset=utf-8");
        //一旦调用getWriter方法，header内容就不能改了
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("firstName: "+firstName);
        writer.write("<br/>");
        writer.write("secondName: "+secondName);
        writer.write("</html>");
    }
//无论参数实在URL中还是body中，最终解析后都放在了Parameter中了,所以可以直接调用doGet方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}