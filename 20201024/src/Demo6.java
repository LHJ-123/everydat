import static java.lang.Thread.interrupted;

public class Demo6 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
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
}
