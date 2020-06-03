public class Main1 {
    public static int count(int[] A, int n) {
        int count1  = 0;
        for(int i = 0;i<n;i++) {
            for(int j = i+1;j<n;j++) {
                if(A[i]>A[j]) {
                    count1++;
                }
            }
        }
        return count1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        int ret = count(a,8);
        System.out.println(ret);
    }
}


