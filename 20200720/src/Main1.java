//day42 2
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.next();
            String s2 = in.next();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0;i<s1.length();i++) {
                char x = s1.charAt(i);
               if(x == 'z') {
                    sb1.append("A");
                }else if(x == 'Z') {
                    sb1.append("a");
                }else if(x == '9') {
                    sb1.append("0");
                }else if(x>'a'&&x<'z') {
                   //(char)(x-31)是吧对应的ascll码值变为对应的字符，再变为字符串加入到sb1里面
                    String y = String.valueOf((char)(x-31));
                    sb1.append(y);
                }else if(x>'A'&&x<'Z') {
                    String y = String.valueOf((char)(x+33));
                    sb1.append(y);
                }else if(x>='0'&&x<'9') {
                    String y = String.valueOf((char)(x+1));
                    sb1.append(y);
                }
            }
            for(int i = 0;i<s2.length();i++) {
                char x = s2.charAt(i);
                if(x == 'a') {
                    sb2.append("Z");
                }else if(x == 'A') {
                    sb2.append("z");

                }else if(x == '0') {
                    sb2.append("9");
                }else if(x>'a'&&x<='z') {
                    String y = String.valueOf((char)(x-33));
                    sb2.append(y);
                }else if(x>'A'&&x<='Z') {
                    String y = String.valueOf((char)(x+31));
                    sb2.append(y);
                }else if(x>'0'&&x<='9') {
                    String y = String.valueOf((char)(x-1));
                    sb2.append(y);
                }
            }
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
        }
    }
}