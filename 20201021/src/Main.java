import java.util.Scanner;

public class Main {
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 7;
        }
        if (n == 1) {
            return 11;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (Fibonacci(i)%(3.0) == 0) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
