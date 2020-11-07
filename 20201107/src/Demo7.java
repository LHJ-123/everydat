class Singleton2 {
    volatile private static Singleton singleton = null;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;

    }
}
public class Demo7 {
    public static void main(String[] args) {
        Singleton s = Singleton.getSingleton();
        Singleton s1 = Singleton.getSingleton();
        System.out.println(s.equals(s1));
    }
}
