import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //Student student = (Student)context.getBean("student");
        //System.out.println(student.getName());
        //System.out.println(student.toString());

        /*ApplicationContext context=new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);*/

        /*ApplicationContext context=new ClassPathXmlApplicationContext("userBeans.xml");
        User user2 = context.getBean("user2",User.class);
        System.out.println(user2);*/

        ApplicationContext context=new ClassPathXmlApplicationContext("userBeans.xml");
        User user3 = context.getBean("user3",User.class);
        User user4 = context.getBean("user3",User.class);
        System.out.println(user3 == user4);
    }
}
