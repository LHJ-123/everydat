import java.util.*;

//描述一个访问磁道任务的类
class MyRunnable implements Runnable {
    public int track;
    public boolean key = true;

    public MyRunnable(int track) {
        this.track = track;
    }

    @Override
    public void run() {
        System.out.print(track + " ");
    }
}

class header {
    public int cur;
    public String direction;

    public header(int index, String direction) {
        this.cur = index;
        this.direction = direction;
    }
}



public class TestDiskScheduling extends Thread {

    List<MyRunnable> threadList = new LinkedList<>();
    public int count;
    public int sum;
    public header head;
    public static final int MaximumTrack = 200;
    //在构造函数里初始化磁头
    public TestDiskScheduling(int index, String direction) {
        this.head = new header(index, direction);
    }
    //需要一个方法往链表为添加程序
    public void add(int[] tracks) throws InterruptedException {
        //创建线程 线程的名字就是他有寻找的磁道地址
        for (int track : tracks
        ) {
            MyRunnable myRunnable = new MyRunnable(track);
            threadList.add(myRunnable);
        }
        threadList.sort(new Comparator<MyRunnable>() {
            @Override
            public int compare(MyRunnable o1, MyRunnable o2) {
                return o1.track - o2.track;
            }
        });
        this.start();
        this.join();
    }

    @Override
    public void run() {
        while (this.count != threadList.size()) {
            while (this.head.direction.equals("right")) {
                for (MyRunnable m : threadList
                ) {
                    if (m.track >= head.cur && m.key) {
                        count++;
                        int distance = m.track - this.head.cur;
                        sum += distance;
                        this.head.cur = m.track;
                        m.key = false;
                        m.run();
                        //threadList.remove(m);
                    }
                    this.head.direction = "left";
                }
            }
            while (this.head.direction.equals("left")) {
                for (int i = threadList.size() - 1; i >= 0; i--) {
                    if (threadList.get(i).track > this.head.cur || !threadList.get(i).key) {
                        continue;
                    }
                    this.count++;
                    int distance = this.head.cur - threadList.get(i).track;
                    sum += distance;
                    this.head.cur = threadList.get(i).track;
                    threadList.get(i).key = false;
                    this.threadList.get(i).run();
                }
                this.head.direction = "right";
            }
        }
    }
    //平均寻道长度
    public float averageSeekLength () {
        return (float) ((this.sum * 1.0) / this.count);
    }

    public static void main(String[] args) throws InterruptedException {
        TestDiskScheduling diskScheduling = new TestDiskScheduling(100, "right");

        int[] num = new int[15];
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            num[i] = random.nextInt(TestDiskScheduling.MaximumTrack);
        }

        System.out.println("磁道请求序列:");
        System.out.println(Arrays.toString(num));
        System.out.println("=========================");
        System.out.println("执行后序列");
        diskScheduling.add(num);
        System.out.println();
        diskScheduling.join();
        System.out.println("=========================");
        System.out.print("平均寻道长度为:");
        System.out.println(diskScheduling.averageSeekLength());

    }
}




