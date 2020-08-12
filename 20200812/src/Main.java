import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for (int i = 0;i<n;i++) {
            value[i] = scanner.nextInt();
            for (int j = sum;j>=0;j--) {
                if (j>=value[i]) {
                    dp[j] += dp[j-value[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
