import com.lei.pojo.Books;
import com.lei.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookService.class);
        List<Books> books = bookService.queryAllBook();
        for (Books books1:books) {
            System.out.println(books1);
        }
    }
}
