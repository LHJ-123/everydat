//day28 1
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int N = in.nextInt();
            int ret = N*N;
            int x = 10;
            while(ret%x!=N&&ret%x!=ret) {
                x = x*10;
            }
            if(ret%x == N) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
}
