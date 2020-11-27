public class Demo {
    public static int test(int n) {
        try {
            n = n+10;
            return n;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            n = n+10;
            return n;
        }
    }
    public static void main(String[] args) {
          int s = 10;
        System.out.println(test(s));
    }
}
