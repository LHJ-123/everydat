//day27 1
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int[] num = new int[n];
            for(int i = 0;i<n;i++) {
                num[i] = in.nextInt();
            }
            int x  = in.nextInt();
            for(int i = 0;i<n;i++) {
                if(num[i] == x) {
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}