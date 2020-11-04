import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];
        int size = arr.length;
        int count = 0;
     int cur = 0;
int i = 0;
        while (cur != size-1) {
            for ( i = 0;i<size;i++) {

               if (arr[i] == -1) {
                   continue;
               }
                arr[i] = count+1;
                if (arr[i]%b == 0 || arr[i]%10 == b) {
                  arr[i] = -1;
                  cur++;
                }
            }
            i = 0;

            System.out.println(Arrays.toString(arr));

        }
        System.out.println(Arrays.toString(arr));
    }
}
