public class Demo1 {
    public static int numberCount(int n) {
        int count = 0;
        while (n>0) {
            ++count;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int x = numberCount(00000000000000000000000000000111);
        System.out.println(x);
    }
}
