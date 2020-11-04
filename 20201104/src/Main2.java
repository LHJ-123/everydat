import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++) {
            arr[i] = scanner.nextInt();
        }
        int count = 1;
        for (int i = 0;i<arr.length-1;i++) {
            if (arr[i] == arr[i+1]) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
