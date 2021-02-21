public class Main {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int two = 0;
        int sum = 1;
        for (int i = 2;i<=39;i++) {
            if (i == n) {
                return sum;
            }
            two = sum-two;
            sum = sum+two;
        }
        return sum;
    }
}
