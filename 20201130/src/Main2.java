import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNext()) {
            s = s+scanner.next()+" ";
        }
        s=s.trim();
        String[] arr = s.split(" ");
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length-1];
        int k = 0;
        for (int i = 0;i<arr.length;i++) {
            arr1[i] = Integer.parseInt(arr[i]);
        }
        k = arr1[arr.length-1];
        for (int i = 0;i<arr2.length;i++) {
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr2);
        for (int i = 0;i<k;i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}
