import java.util.Scanner;

public class Main1 {
    public static int Fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        return Fibonacci(n-1)+Fibonacci(n-2)+Fibonacci(n-3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = Fibonacci(n);
        System.out.println(ret);
    }
}
