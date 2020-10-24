class MyThread4 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0;i<100000;i++) {
            System.out.println("i="+(i+1));
        }
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，在遇到sleep，进入catch");
            e.printStackTrace();
        }
    }
}
public class Demo8 {
    public static void main(String[] args) {
        MyThread4 thread4 = new MyThread4();
        thread4.start();
        thread4.interrupt();
        System.out.println("end!");
    }
}
