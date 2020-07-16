import java.util.Arrays;
//day 39 1
public class Main {
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] a = new int[n*n];
        int i = 0;
        for(int x = n-1;x>=1;x--) {
            int tmp = x;
            int count = 0;
            if(tmp+1 == n) {
                a[i] = arr[count][tmp];
                i++;
                tmp--;
            }else{
                while (tmp+1<=n) {
                    a[i] = arr[count][tmp];
                    i++;
                    count++;
                    tmp++;
                }
            }
        }
        for (int o = 0;o<n;o++) {
            a[i] = arr[o][o];
            i++;
        }
        for(int x = 1;x<=n-1;x++) {
            int tmp = x;
            int count = 0;
            if(tmp+1 == n) {
                a[i] = arr[tmp][count];
                i++;
                tmp++;
            }else{
                while (tmp+1<=n) {
                    a[i] = arr[tmp][count];
                    i++;
                    count++;
                    tmp++;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(arrayPrint(a,4)));
    }
}
