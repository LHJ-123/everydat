public class ThreadDemo3 {
    static class BlockingQueue {
        //基于数组实现
        private int[] array = new int[1000];
        private int head = 0;
        private  int tail = 0;
        private int size = 0;

        public  void put(int value) throws InterruptedException {
            synchronized (this) {
                if (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;
                notify();
            }
        }

        public  int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                if (size == 0) {
                    wait();
                }
                 ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i<10000;i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产成功"+i);
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        producer.start();
        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素"+ret);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        consumer.start();
    }
}
