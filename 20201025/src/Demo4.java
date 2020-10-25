class MyThread3 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i="+(i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo4 {
    public static void main(String[] args) {
        try {
            MyThread3 thread3 = new MyThread3();
            thread3.setDaemon(true);
            thread3.start();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("我离开thread3对象也不再打印了，也就停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
