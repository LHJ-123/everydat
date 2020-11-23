class test{
    test() {
        System.out.println(123);
    }
}
public class Demo extends test{
    public static void main(String[] args) {
        new Demo();
        new test();
    }
}
