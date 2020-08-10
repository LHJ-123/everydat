import frank.Duck;
import frank.Duck2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        String lhj = (String)context.getBean("lhj");
        System.out.println(lhj);
        //通过类型获取bean对象，如果该类型有多个对象，就会报错
        String lhj1 = context.getBean(String.class);
        System.out.println(lhj1);
        //自定义类型
        Duck duck = (Duck)context.getBean("hhh");
        System.out.println(duck);
        //有参数的构造方法
        Duck2 duck2 = (Duck2)context.getBean("hhh2");
        System.out.println(duck2);
    }
}

