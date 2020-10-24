class MyThread3 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止"+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
public class Demo7 {
    public static void main(String[] args) {
        try {
            MyThread3 thread3 = new MyThread3();
            thread3.start();
            Thread.sleep(200);
            thread3.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
