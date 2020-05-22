import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private String name = "秘密";

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {

    }

    public void eat(String food) {
        System.out.println(name +"正在吃"+food);
    }

    public void eat(String food1,String food2) {
        System.out.println(name+"正在吃"+food1+","+food2);
    }
}
public class TestReflect {
    //借助反射实例化对象
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        Class catClass = Class.forName("Cat");

        Cat cat = (Cat)catClass.newInstance();
    }

    //借助反射获取对象的属性
    public static void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取类对象
        Class catClass = Class.forName("Cat");
        //借助类对象，获取指定的Field对象
        Field field = catClass.getDeclaredField("name");
        field.setAccessible(true);//专门处理private成员方式
        //根据图纸修改
        Cat cat = new Cat();
        field.set(cat,"步步");//根据图纸修改属性
        String name = (String)field.get(cat);
        System.out.println(name);
    }

    //借助反射获取对象方法
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class catClass = Class.forName("Cat");
        //从第二个参数开始都是用来描述是哪个版本的eat
        Method method = catClass.getMethod("eat",String.class);
       // Method method2 = catClass.getMethod("eat",String.class,String.class);
        Cat cat = new Cat();
        method.invoke(cat,"鱼");
    }

    //借助反射调用构造方法
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class catClass = Class.forName("Cat");
        Constructor constructor = catClass.getConstructor(String.class);
        constructor.setAccessible(true);
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("猫粮");
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
       // testField();
        //testMethod();
        testConstructor();

    }

}
