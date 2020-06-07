public class ThreadDemo4 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("正在转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("转账结束");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("对方是内鬼终止交易");
        isQuit = true;
    }
}
