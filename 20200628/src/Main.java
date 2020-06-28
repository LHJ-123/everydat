//day 24
import java.util.Scanner;
public class Main {
    public static int max(int a,int b) {
        if(a<b) {
            int m = a;
            a = b;
            b = m;
        }
        while(b!=0) {
            if(a == b) {
                return a;
            }
            int k = a%b;
            a = b;
            b = k;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int a = in.nextInt();
            int[] b = new int[n];
            for(int i = 0;i<n;i++) {
                b[i] = in.nextInt();
            }
            for(int i = 0;i<n;i++) {
                if(b[i]<=a) {
                    a = a+b[i];
                }else {
                    int result = max(b[i],a);
                    a = a+result;
                }
            }
            System.out.println(a);
        }
    }
}