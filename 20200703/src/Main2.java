// day 29 1
import java.util.Scanner;
public class Main2 {
    public static double result(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return (n-1)*(result(n-1)+result(n-2));
    }
    public static double reault1(int n) {
        if(n == 1) {
            return 1;
        }
        return n*reault1(n-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            double x1 = result(n);
            double x2 = reault1(n);
            double x3 = (x1/x2)*100;
            System.out.println(String.format("%.2f",x3)+"%");
        }
    }
}