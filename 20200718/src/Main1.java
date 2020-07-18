//javaweb 考试
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++) {
            int ret = -1;
            if(i == 0) {
                for(int j = 1;j<n;j++) {
                    if(arr[i]>arr[j]) {

                        ret = j;
                        break;
                    }
                }
                System.out.println(-1+" "+ret);
                continue;
            }
            int x = -1;
            if(i == n-1) {
                for(int j = n-2;j>=0;j--) {

                    if(arr[i]>arr[j]) {

                        x = j;
                        break;
                    }
                }
                System.out.println(x+" "+-1);
                continue;
            }
            int a = -1;
            int b = -1;
            for(int j = i-1;j>=0;j--) {
                if(arr[i]>arr[j]) {
                    a = j;
                    break;
                }
            }
            for(int j = i+1;j<n;j++) {
                if(arr[i]>arr[j]) {
                    b = j;
                    break;
                }
            }
            System.out.println(a+" "+b);
        }

    }
}