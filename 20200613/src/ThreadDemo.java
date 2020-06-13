public class ThreadDemo {
    static class Singleton {
        //变为私有，就没法在类外构造实例
        //饿汉模式
        //只要类被加载，就立刻会被实例化
        private Singleton() {

        }
        private static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s .equals(s2));
    }
}
