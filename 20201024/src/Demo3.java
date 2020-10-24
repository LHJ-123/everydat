import static java.lang.Thread.interrupted;

class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0;i<50;i++) {
            System.out.println("i="+(i+1));
        }
    }
}
public class Demo3 {
    public static void main2(String[] args) {
        try {
            MyThread2 thread = new MyThread2();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("是否停止1? ="+interrupted());
            System.out.println("是否停止2? ="+interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }

    public static void main1(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1? ="+Thread.interrupted());
        System.out.println("是否停止2? ="+Thread.interrupted());
        System.out.println("end!");
    }

    public static void main(String[] args) {
        try {
            MyThread2 thread = new MyThread2();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("是否停止1? ="+thread.isInterrupted());
            System.out.println("是否停止2? ="+thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
