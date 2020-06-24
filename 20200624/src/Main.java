//day 21
import java.util.Scanner;
public class Main {
    public static int getTotalCount(int monthCount) {
        if(monthCount == 1|| monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int ret = getTotalCount(n);
            System.out.println(ret);
        }

    }
}
