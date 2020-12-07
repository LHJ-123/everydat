import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char s = scanner.next().charAt(0);
        int cur =  Math.round((float)(n/2.0));
        System.out.println(cur);
        for (int i = 0;i<cur;i++) {
            for (int j = 0;j<n;j++) {
                if (i != 0 && i != cur-1) {
                    if (j == 0 || j == n-1) {
                        System.out.print(s);
                    }else {
                        System.out.print(" ");
                    }
                }else {
                    System.out.print(s);
                }
            }
            System.out.println();
        }
    }
}
