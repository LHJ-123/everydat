import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0;i<arr.length;i++) {
            arr[i] = in.nextInt();
            if (arr[i] == 0) {
                break;
            }
        }
        for (int i = 0;i<arr.length;i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]/2);
            }else {
                break;
            }
        }
    }
}
