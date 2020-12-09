import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        while (T != 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[2*n+2];
            arr[0] = n;
            arr[1] = k;
            for (int i = 2;i<arr.length;i++) {
                arr[i] = scanner.nextInt();
            }
            list.add(arr);
            T--;
        }
        for (int[] arr:list) {
            int[] arr1 = new int[arr.length-2];
            int k = arr[1];
            for (int i = 0;i<arr1.length;i++) {
                arr1[i] = arr[i+2];
            }
            while (k!=0) {
                cleanCard(arr1);
                k--;
            }
            for (int i = 0;i<arr1.length;i++) {
                if (i == arr1.length-1) {
                    System.out.print(arr1[i]);
                }else {
                    System.out.print(arr1[i]+" ");
                }
            }
            System.out.println();
        }

    }

    private static void cleanCard(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        int i = 0;
        for (int cur = 0;cur<arr1.length;cur+=2) {
            arr2[cur] = arr1[i];
            i++;
        }
        for (int cur = 1;cur<arr1.length;cur+=2) {
            arr2[cur] = arr1[i];
            i++;
        }
        for (int cur = 0;cur<arr1.length;cur++) {
            arr1[cur] = arr2[cur];
        }
    }
}
