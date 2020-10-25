class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread run priority="+this.getPriority());
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 run priority="+this.getPriority());
    }
}
public class Demo2 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority="+Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}
