public class ThreadDemo2 {
    //懒汉模式
    static class Singleton {
        private Singleton() {

        }
        private volatile static Singleton instance = null;
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {

    }
}
