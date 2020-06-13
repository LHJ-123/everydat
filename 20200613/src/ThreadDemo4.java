import java.util.concurrent.PriorityBlockingQueue;

class Task implements Comparable<Task>{
    //用runnable中的run方法来描述这个任务是啥
    public Runnable command;
    public long time;

    public Task(Runnable command, long after) {
        this.command = command;
        this.time = System.currentTimeMillis()+after;
        //相对时间，毫秒级别的时间戳
    }
    public void run() {
        command.run();
    }

    @Override
    public int compareTo(Task o) {
        return (int)(this.time-o.time);
    }
}
class Worker extends Thread {
    public PriorityBlockingQueue<Task> queue = null;
    public Object mailBox = null;
    public Worker( PriorityBlockingQueue<Task> queue,Object mailBox) {
        this.mailBox = mailBox;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = queue.take();
                long curTime = System.currentTimeMillis();
                if (task.time>curTime) {
                    queue.put(task);
                    synchronized (mailBox) {
                        mailBox.wait(task.time-curTime);
                    }
                }else {
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
class Timer {
    public Object mailBox = new Object();
    public PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
    public Timer() {
        Worker worker = new Worker(queue,mailBox);
        worker.start();
    }
    public void schedule(Runnable command,long after) {
        Task task = new Task(command,after);
        queue.put(task);
        synchronized (mailBox) {
            mailBox.notify();
        }
    }



}

public class ThreadDemo4 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this,2000);
            }
        },2000);
    }

}
