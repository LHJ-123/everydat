//day 26 1
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int sum1 = 0;
            int ret = n*n;

            while(n!=0) {
                sum1 = sum1+n%10;
                n = n/10;
            }
            int sum2 = 0;
            while(ret!=0) {
                sum2 = sum2+ret%10;
                ret = ret/10;
            }
            System.out.println(sum1 +" "+ sum2);
        }
    }
}
