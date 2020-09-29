import java.util.Scanner;

public class Demo4 {
    public  int sumBin(int a,int b) {
        int j = a^b;
        int x = a&b;
        int jin = x<<1;
        while (jin != 0) {
            int j1 = j^jin;
            int jin1 = (j&jin)<<1;
            j = j1;
            jin = jin1;
        }
        return j;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ret = sumBin(a,b);
        System.out.println(ret);
    }*/
}
