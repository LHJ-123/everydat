import java.util.Scanner;


//求最小公倍数
public class Main2 {
    public static int maxDev(int a,int b) {
        if (b == 0) {
            return a;
        }
        return maxDev(b,a%b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println((a*b)/maxDev(a,b));
    }
}
