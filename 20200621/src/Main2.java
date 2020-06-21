public class Main2 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.start();
        System.out.print("A");
    }
    static void pong() {
        System.out.print("B");
    }
}
