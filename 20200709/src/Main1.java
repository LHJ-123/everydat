//day34 2
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            int z0 = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int z1 = in.nextInt();
            double num = Math.pow(x1-x0,2)+Math.pow(y1-y0,2)+Math.pow(z1-z0,2);
            double num1 = Math.pow(num,1.0/2);
            double num2 = (4.0/3)*Math.acos(-1)*Math.pow(num1,3);
            System.out.println(String.format("%.3f",num1));
            System.out.println(String.format("%.3f",num2));
        //}
    }
}