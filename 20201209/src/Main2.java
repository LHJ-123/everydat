import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n != 0) {
                int[] arr = new int[n+1];
                for (int i = 0;i<arr.length-1;i++) {
                    arr[i] = scanner.nextInt();
                }
                int k = scanner.nextInt();
                arr[n] = k;
                list.add(arr);
            }else {
                break;
            }
        }
        for (int[] arr:list) {
            int count = 0;
            for (int i = 0;i<arr.length-1;i++) {
                if (arr[i] == arr[arr.length-1]) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
