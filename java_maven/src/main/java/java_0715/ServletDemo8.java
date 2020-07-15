package java_0715;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class ServletDemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        int count = 1;
        if (httpSession.isNew()) {
            httpSession.setAttribute("count",count);
        }else {
            count = (Integer)httpSession.getAttribute("count");
            count = count+1;
            httpSession.setAttribute("count",count);
        }
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("count: "+count);
        writer.write("</html>");
    }
}
