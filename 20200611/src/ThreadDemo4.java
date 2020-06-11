import java.util.Scanner;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (locker) {
                    while (true) {
                        try {
                            System.out.println("wait开始");
                            locker.wait();
                            System.out.println("wait结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入整数");
                int num = scanner.nextInt();
                synchronized (locker) {
                    System.out.println("notify开始");
                    locker.notify();
                    System.out.println("notify结束");
                }
            }
        };
        t2.start();
    }

}
