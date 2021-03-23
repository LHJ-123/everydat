public class Main2 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //0 1 1 2 3 5 8
        int one = 0;
        int two = 1;
        for (int i = 2;i<=n;i++) {
            two = two+one;
            one = two-one;
        }
        return two;
    }
}
