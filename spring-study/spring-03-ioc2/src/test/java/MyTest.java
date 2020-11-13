import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //User user = new User();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)context.getBean("user2");
        user.show();
    }
}
