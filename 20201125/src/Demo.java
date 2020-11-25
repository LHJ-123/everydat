public class Demo {
    public static void fun1() {
        System.out.println(1);
    }
    public void fun2() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo.fun1();
        demo.fun2();
    }
}
