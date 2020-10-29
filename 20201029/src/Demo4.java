
//同步不能继承，所以还需要在子类的方法中添加synchronized关键字
class Main1 {
    synchronized public void serviceMethod() {
        try {
            System.out.println("int main 下一步sleep begin threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int main 下一步sleep end threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Sub1 extends Main1 {
    @Override
    public synchronized void serviceMethod() {
        try {
            System.out.println("int sub 下一步sleep begin threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub 下一步sleep end threadName="+Thread.currentThread().getName()+" time="+System.currentTimeMillis());
            super.serviceMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadE extends Thread {
    private Sub1 sub1;

    public ThreadE(Sub1 sub1) {
        this.sub1 = sub1;
    }

    @Override
    public void run() {
        sub1.serviceMethod();
    }
}
class ThreadF extends Thread {
    private Sub1 sub1;

    public ThreadF(Sub1 sub1) {
        this.sub1 = sub1;
    }

    @Override
    public void run() {
        sub1.serviceMethod();
    }
}
public class Demo4 {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1();
        ThreadE threadE = new ThreadE(sub1);
        threadE.setName("A");
        threadE.start();
        ThreadF threadF = new ThreadF(sub1);
        threadF.setName("B");
        threadF.start();
    }
}
