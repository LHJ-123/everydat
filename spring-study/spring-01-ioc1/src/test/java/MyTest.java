import dao.UserDaoMysql;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
       /* UserService userService = new UserServiceImpl();
      ((UserServiceImpl) userService).setUserDao(new UserDaoMysql());
        userService.getUser();*/
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userService = (UserServiceImpl)context.getBean("userServiceImpl");
        userService.getUser();
    }
}
