public class ThreadDemo2 {
    private static long count = 10000000000L;
    public static void main(String[] args) {
        seriaL();
        concurrency();
    }

    private static void concurrency() {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread() {//匿名内部类

            @Override
            public void run() {
                int a = 0;
                for(long i = 0;i<count;i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread() {//匿名内部类

            @Override
            public void run() {
                int b = 0;
                for(long i = 0;i<count;i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //让主线程等待t1,t2执行结束
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//t1和t2和main线程之间都是并发进行的
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-beg)+"ms");

    }

    private static void seriaL() {
        long beg = System.currentTimeMillis();//获取时间戳
        int a = 0;
        for(long i = 0;i<count;i++) {
            a++;
        }
        int b = 0;
        for(long i = 0;i<count;i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-beg)+"ms");

    }
}
