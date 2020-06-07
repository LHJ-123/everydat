public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("别管我忙着转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账结束");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("终止交易");
        t.interrupt();

    }
}
