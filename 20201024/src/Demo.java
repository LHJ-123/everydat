class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName="+currentThread().getName()+"begin");
            Thread.sleep(2000);
            System.out.println("run threadName="+currentThread().getName()+"end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo {
    public static void main1(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin="+System.currentTimeMillis());
        myThread1.run();
        System.out.println("end="+System.currentTimeMillis());

    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin="+System.currentTimeMillis());
        myThread1.start();
        System.out.println("end="+System.currentTimeMillis());
    }
}
