class MyThread extends Thread {
    private int count = 5;//不共享

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count>0) {
            count--;
            System.out.println("由:"+currentThread().getName()+"计算,count="+count);
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        MyThread myThread2 =  new MyThread("C");
        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
