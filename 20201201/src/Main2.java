import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = String.valueOf(n);
        for (int i = s.length()-1;i>=0;i--) {
            System.out.print(s.charAt(i));
        }
    }
}
