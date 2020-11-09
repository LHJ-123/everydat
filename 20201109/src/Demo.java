public class Demo {
    public static void main(String[] args) {
        String lock = new String();
        System.out.println("syn上面");
        synchronized (lock) {
            System.out.println("syn第一行");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait下的代码");
        }
        System.out.println("syn下面");
    }
}
