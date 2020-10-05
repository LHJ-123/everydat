import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Demo {
    //斐波那契数列
    public int Fibonacci(int n) {
        if (n<=0) {
            return 0;
        }
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2;i<array.length;i++) {
            array[i] = array[i-1]+array[i-2];
        }
        return array[n];
    }

    //青蛙跳台阶
    //n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
    //跳1级，剩下n-1级，则剩下跳法是f(n-1)
    //跳2级，剩下n-2级，则剩下跳法是f(n-2)
    //f(n) = f(n-1)+f(n-2)+...+f(n-n)
    //f(n) = f(n-1)+f(n-2)+...+f(0)
    //f(n-1) = f(n-2)+...+f(0)
    //f(n) = 2*f(n-1)
    public int JumpFloor(int n) {
        if (n == 0) {
            return 0;
        }
        int ret = 1;
        for (int i = 2;i<=n;i++) {
            ret = ret*2;
        }
        return ret;
    }

    //找数组最大连续和
    //F(i) = max(F(i-1) + array[i]，array[i])
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 0;i<array.length;i++) {
            curSum = Math.max(curSum+array[i],array[i]);
            if (curSum>maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

   // 给定一个字符串和一个词典dict，确定s是否可以根据词典中的词分成一个或多个单词
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for (int i = 1;i<=s.length();i++) {
            for (int j = i-1;j>=0;j--) {
                if (canBreak[j]&&dict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    //给出一个三角形，计算从三角形顶部到底部的最小路径和，
    //每一步都可以移动到下面一行相邻的数字
    //F(i,j):min(F(i-1,j),F(i-1,j-1))+a[i][j];
    //每一行第一列，最后一列只有一条路径可以到达
    //F(i,O): F(i-1,0)+ a[i][0]
    //F(i, i): F(i - 1,i - 1) +a[i][i]
    //初始状态:F(0,0)=a[0][0]
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        List<List<Integer>> minPathSum = new ArrayList<>();
        for (int i = 0;i<triangle.size();i++) {
            minPathSum.add(new ArrayList<>());
        }
        minPathSum.get(0).add(triangle.get(0).get(0));
        for (int i = 1;i<triangle.size();i++) {
            int curSum = 0;
            for (int j = 0;j<=i;j++) {
                if (j == 0) {
                    curSum = minPathSum.get(i-1).get(0);
                }else if (j == i) {
                    curSum = minPathSum.get(i-1).get(j-1);
                }else {
                    curSum = Math.min(minPathSum.get(i-1).get(j),minPathSum.get(i-1).get(j-1));
                }
                minPathSum.get(i).add(triangle.get(i).get(j)+curSum);
            }
        }
        int size = triangle.size();
        int allMin = minPathSum.get(size-1).get(0);
        for (int i = 1;i<size;i++) {
            allMin = Math.min(allMin,minPathSum.get(size-1).get(i));
        }
        return allMin;
    }

    //一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置)。
    //机器人每次向下或向右移动。机器人要到达地图的右下角。(终点，下图中的标记“Finish"的位置)。
    //可以有多少种不同的路径从起点走到终点?
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
        for (int i = 0;i<m;i++) {
            pathNum[i][0] = 1;
        }
        for (int i = 0;i<n;i++) {
            pathNum[0][i] = 1;
        }
        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                pathNum[i][j] = pathNum[i][j-1]+pathNum[i-1][j];
            }
        }
        return pathNum[m-1][n-1];
    }

    //如果在图中加入了一些障碍，有多少不同的路径?
    //分别用O和1代表空区域和障碍
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] pathNum = new int[row][col];
        for (int i = 0;i<row;i++) {
            if (obstacleGrid[i][0] == 0) {
                pathNum[i][0] = 1;
            }else {
                break;
            }
        }
        for (int j = 0;j<col;j++) {
            if (obstacleGrid[0][j] == 0) {
                pathNum[0][j] = 1;
            }else {
                break;
            }
        }
        for (int i = 1;i<row;i++) {
            for (int j = 1;j<col;j++) {
                if (obstacleGrid[i][j] == 0) {
                    pathNum[i][j] = pathNum[i][j-1]+pathNum[i-1][j];
                }
            }
        }
        return pathNum[row-1][col-1];
    }

    //有n个物品和一个大小为m 的背包.给定数组A表示每个物品的大小和数组V表示每个物品的价值.
    //问最多能装入背包的总价值是多大?

    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] maxValue = new int[n+1][m+1];
        for (int i = 1;i<=n;i++) {
            for (int j = 1;j<=m;j++) {
                if (A[i-1]<=j) {
                    maxValue[i][j] = Math.max(maxValue[i-1][j],maxValue[i-1][j-A[i-1]]+V[i-1]);
                }else {
                    maxValue[i][j] = maxValue[i-1][j];
                }
            }
        }
        return maxValue[n][m];
    }

}
