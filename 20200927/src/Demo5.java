public class Demo5 {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        int j = a^b;
        int x = a&b;
        int jin = x<<1;
        while (jin != 0) {
           int j1 = j^jin;
           int jin1 = (j&jin)<<1;
           j = j1;
           jin = jin1;
        }
        System.out.println(j);
        int y = 22 >>>2;
        System.out.println(y);
    }
}
