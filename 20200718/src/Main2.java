import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        int max = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                int sum= 0;
                for(int m = i;m<=j;m++) {
                    sum = sum+arr[m];
                }
                if(max<sum) {
                    max= sum;
                }
            }
        }
        System.out.println(max);
    }
}