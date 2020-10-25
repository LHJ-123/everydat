class ThreadA extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
class ThreadB extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
public class Demo3 {
    public static void main(String[] args) {
        try {
            ThreadA threadA = new ThreadA();
            threadA.setPriority(Thread.NORM_PRIORITY-3);
            threadA.start();
            ThreadB threadB = new ThreadB();
            threadB.setPriority(Thread.NORM_PRIORITY+3);
            threadB.start();
            Thread.sleep(20000);
            threadA.stop();
            threadB.stop();
            System.out.println("threadA="+threadA.getCount());
            System.out.println("threadB="+threadB.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
