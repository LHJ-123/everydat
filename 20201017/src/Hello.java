class A {
    public void fun() {
        System.out.println("不是静态方法");
    }
    public static void fun1() {
        System.out.println("是一个静态方法");
    }

}
class B {
    public void fun() {
        System.out.println("不是静态方法");
    }
    public static void fun1() {
        System.out.println("是一个静态方法");
    }
}

class C {
    public void fun() {
        System.out.println("不是静态方法");
    }
    public static void fun1() {
        System.out.println("是一个静态方法");
    }

}
public class Hello {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.fun();
        A.fun1();
        b.fun();
        B.fun1();
        c.fun();
        C.fun1();
    }
}
