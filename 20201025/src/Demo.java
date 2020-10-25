import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = scanner.nextInt();
        while (scanner.hasNext()) {
            sum += scanner.nextInt();
            if (sum>max) {
                max = sum;
            }
            if (sum<0) {
                sum = 0;
            }
        }
        System.out.println(max);
    }
}
