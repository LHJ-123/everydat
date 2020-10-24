class MyThread5 extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }
            System.out.println("timer="+System.currentTimeMillis());
        }
    }
}
public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        MyThread5 thread5 = new MyThread5();
        thread5.start();
        Thread.sleep(2000);
        thread5.interrupt();
    }
}
