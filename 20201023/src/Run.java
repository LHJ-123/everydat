class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中");
    }
}
public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
       Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
