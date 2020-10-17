import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void printStar(int number) {
        int len = number*2-1;
        char[][] n = new char[len][len];
        int cur1 = len/2-1;
        int cur2 = len/2+1;
        n[0][len/2] = '*';
        for (int i = 2;i<len;i+=2) {
            n[i][cur1] = '*';
            n[i][cur2] = '*';
            cur1--;
            cur2++;
        }
        for (int i = 1;i<len;i++) {
            n[len-1][i] = '*';
        }
        for (int i = 0;i<len;i++) {
            for (int j = 0;j<len;j++) {
                if (n[i][j] != '*') {
                    n[i][j] = ' ';
                }
            }
        }
        for (int i = 0;i<len;i++) {
            for (int j = 0;j<len;j++) {
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printStar(n);
    }
}
