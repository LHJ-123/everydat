import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
     BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
     List<Worker> workers = new ArrayList<>();
     final int maxWorkerCount = 10;
     public void execute(Runnable command) throws InterruptedException {
         if (workers.size()<maxWorkerCount) {
             Worker worker = new Worker(queue);
             worker.start();
             workers.add(worker);
         }
         queue.put(command);
     }

    public void shutdown() throws InterruptedException {
         for (Worker worker:workers) {
             worker.interrupt();
         }
         for (Worker worker:workers) {
             worker.join();
         }
    }
}
class Worker extends Thread{
    BlockingQueue<Runnable> queue = null;

    public Worker(BlockingQueue<Runnable> queue) {


        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable command = queue.take();
                command.run();
            }
        } catch (InterruptedException e) {
            System.out.println("线程被终止");
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for(int i = 0;i<1000;i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我在执行任务:");
                }
            });
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程已经被销毁");
    }
}
