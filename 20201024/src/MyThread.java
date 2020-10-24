public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0;i<500000;i++) {
                if (interrupted()) {
                    System.out.println("已经是停止状态，退出");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println("我在for下面");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("进run方法中的catch中了");
        }
    }
}
