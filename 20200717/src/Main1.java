import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            String[] s1 = s.split(" ");

           for (int i = s1.length-1;i>=0;i--) {
               System.out.print(s1[i]+" ");
           }
        }
    }
}