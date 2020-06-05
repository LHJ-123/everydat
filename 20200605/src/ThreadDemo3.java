public class ThreadDemo3 {
   /* static class MyRunnable implements Runnable {
        //本质是描述了要执行的任务代码是啥
        @Override
        public void run() {
            System.out.println("我是新线程");
        }
    }*/
    public static void main(String[] args) {
       /* Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是新线程");
            }
        };
        Thread t = new Thread(runnable);
        t.start();*/
       Thread t = new Thread(()-> {
           System.out.println("我是一个新线程");
       });
       t.start();

    }
}
