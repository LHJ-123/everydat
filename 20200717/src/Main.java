import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s1.length();i++) {
                char a = s1.charAt(i);
                String x = String.valueOf(a);

                if(!s2.contains(x)) {
                   sb.append(x);
                }
            }
            System.out.println(sb.toString());
        }
    }
}