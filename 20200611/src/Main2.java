

public class Main2 {
    public static int countWays(int x, int y) {
        int dp[][] = new int[x][y];
        for(int i = 0; i < x; i++){
            dp[i][0] = 1;
        }
        for(int j =0; j< y; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i< x;i++){
            for(int j =1;j<y;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[x-1][y-1];

    }

    public static void main(String[] args) {
        int ret = countWays(3,3);
        System.out.println(ret);
    }
}
