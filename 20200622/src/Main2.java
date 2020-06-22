public class Main2 {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "333";
        System.out.println(s1);
        System.out.println(s2);
        String a = s1;
        s1 = s2;
        s2 = a;
        System.out.println(s1);
        System.out.println(s2);

    }
}
