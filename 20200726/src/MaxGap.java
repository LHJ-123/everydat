import java.util.*;
//day48 1
public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int max = A[0];
        for(int i = 1;i<n;i++) {
            if(A[i]>max) {
                max = A[i];
            }
        }
        int min = A[0]>A[n-1]?A[n-1]:A[0];
        return max-min;
    }
}