//day 28 2
import java.util.Scanner;
public class Main1 {
    public static boolean checkLength(String s) {

        if(s.length()>8) {
           return true;
        }else {
           return false;
        }
    }
    public static boolean checkKinds(String s) {
        int x = 0;
        int y = 0;
        int z = 0;
        int w = 0;
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
                x = 1;
                continue;
            }
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z') {
                y = 1;
                continue;
            }
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                z = 1;
                continue;
            }else {
                w = 1;
                continue;
            }
        }
        if(x+y+z+w>=3) {
          return true;
        }else {
            return false;
        }
    }
    public static boolean checkRepeat(String s) {
        for(int i = 0;i<s.length()-2;i++) {
            String s1 = s.substring(i,i+3);
            if(s.substring(i+2).contains(s1)) {
               return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            if(checkLength(s)&&checkKinds(s)&&checkRepeat(s)) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
}
