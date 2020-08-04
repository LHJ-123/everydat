class A{
    public int num = 0;
}

class B{
    public int count = 0;
    public A a;
}

public class Demo1 {
    public static void main(String[] args) {
        B b = new B();
        b.count = 10;
        b.a = new A();
        b.a.num = 100;

    }
}
