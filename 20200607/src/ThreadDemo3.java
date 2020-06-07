public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread("线程") {
            @Override
            public void run() {
                for(int i = 0;i<10;i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //run方法执行中，内核的线程就存在
                //run方法执行完毕，线程就随之销毁
                System.out.println("线程要结束了");
            }
        };

        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());

        System.out.println(t.getState());
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        t.start();
    }
}
