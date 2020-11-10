class MyThread extends Thread {
    @Override
    public void run() {
        int secondValue = (int)(Math.random()*10000);
        System.out.println(secondValue);
        try {
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我在子线程执行完后执行");
    }
}
