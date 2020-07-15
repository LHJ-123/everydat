package java_0715;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig //注解必须有，提示我们要处理文件
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String basePath = "e:/images/";
         Part image = req.getPart("image");
         String path = basePath+image.getSubmittedFileName();
         image.write(path);
         resp.setContentType("text/html; charset=utf-8");
         resp.getWriter().write("图片上传成功");
    }
}
