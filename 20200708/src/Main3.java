import java.util.*;
//day33 2
public class Main3 {
    public int countWays(int n) {
        // write code here

        int[] arr = new int[100001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4;i<=100000;i++) {
            //因为两个数之和也可能会溢出
            arr[i] = ((arr[i-1]+arr[i-2])%1000000007+arr[i-3])%1000000007;
        }
        return arr[n];

    }
}