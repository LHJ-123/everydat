public class ThreadDeno7 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("我是新线程");
            }
        };
        t.start();
        System.out.println("我是主线程");
    }

}
