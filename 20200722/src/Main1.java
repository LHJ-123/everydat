import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        for (int i = arr.length-1;i>=0;i--) {
            if (i != 0) {
                System.out.print(arr[i]+" ");
            }else {
                System.out.println(arr[i]);
            }
        }
    }
}
