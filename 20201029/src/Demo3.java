//出现异常，锁自动释放

class Test {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName="+Thread.currentThread().getName()+"run beginTime="+System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if ((""+Math.random()).substring(0,8).equals("0.123456")) {
                    System.out.println("ThreadName="+Thread.currentThread().getName()+"run exceptionTime="+System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println("Thread B run Time="+System.currentTimeMillis());
        }
    }
}
class ThreadC extends Thread {
    private Test test;

    public ThreadC(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.testMethod();
    }
}
class ThreadD extends Thread {
    private Test test;

    public ThreadD(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.testMethod();
    }
}
public class Demo3 {
    public static void main(String[] args) {
        try {
            Test test = new Test();
            ThreadC threadC = new ThreadC(test);
            threadC.setName("a");
            threadC.start();
            Thread.sleep(500);
            ThreadD threadD = new ThreadD(test);
            threadD.setName("b");
            threadD.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
