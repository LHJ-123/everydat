import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0;i<arr.length;i++) {
            for (int j = i+1;j<arr.length;j++) {
                if (arr[j]-arr[i] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
