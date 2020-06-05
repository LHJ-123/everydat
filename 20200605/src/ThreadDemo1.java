public class ThreadDemo1 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello world");
        }
    }
    public static void main(String[] args) {
        //需要使用Thread类  还需指定这个线程要执行哪些指令
        //重写Thread中的run方法
        //Thread对象被创建出来时，内核中并没产生线程
        Thread t = new MyThread();
        //执行start方法才创建了一个线程
        t.start();
    }
}
