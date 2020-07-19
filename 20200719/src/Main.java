//day 41 2
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            String[] arr = s.split(";");
            int x = 0;
            int y = 0;
            for(int i = 0;i<arr.length;i++) {
                char cur = arr[i].charAt(0);
                String s1 = arr[i].substring(1);
//正则表达式，表示字符串是否由数字组成
                if(cur == 'A'&&s1.matches("[0-9]+")) {
                    x = x-Integer.valueOf(s1);
                    continue;
                }
                if(cur == 'D'&&s1.matches("[0-9]+")) {
                    x = x+Integer.valueOf(s1);
                    continue;
                }
                if(cur == 'S'&&s1.matches("[0-9]+")) {
                    y = y-Integer.valueOf(s1);
                    continue;
                }
                if(cur == 'W'&&s1.matches("[0-9]+")) {
                    y = y+Integer.valueOf(s1);
                    continue;
                }
            }
            System.out.println(x+","+y);
        }
    }
}