import java.util.Arrays;
import java.util.Scanner;

public class Demo3 {
    public  int[] nicoTheo(int n) {
        int[] x = new int[n];
        int m = n*(n-1)+1;
        for (int i = 0;i<x.length;i++) {
            x[i] = m;
            m+=2;
        }
        return x;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c =  nicoTheo(n);
        System.out.println(Arrays.toString(c));
    }*/
}
