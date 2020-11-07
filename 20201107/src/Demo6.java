class Singleton {
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }
}
public class Demo6 {
    public static void main(String[] args) {
        Singleton s = Singleton.getSingleton();
        Singleton s1 = Singleton.getSingleton();
        System.out.println(s.equals(s1));
    }
}
