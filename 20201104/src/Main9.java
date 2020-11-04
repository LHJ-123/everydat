import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++) {
            arr[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i<arr.length;i++) {
            if (sum<=0) {
                sum = arr[i];
            }else {
                sum = sum+arr[i];
            }
            if (sum>max) {
                max = sum;
            }
        }
        if (max<0) {
            max = 0;
        }
        System.out.println(max);
    }
}
