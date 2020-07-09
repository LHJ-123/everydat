//day34 1
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine().toUpperCase();
        String s2 = in.nextLine().toUpperCase();
        String s3 = "";
        char[] c = s1.toCharArray();
        for (int i = 0;i<c.length;i++) {
            String s4 = String.valueOf(c[i]);
            if (s2.contains(s4)) {
                continue;
            }else {
                s3 = s3+s4;
            }
        }

     String s5 = "";
        char[] c1 = s3.toCharArray();
        for (int i = 0;i<c1.length;i++) {
            String s6 = String.valueOf(c1[i]);
            if (s5.contains(s6)) {
                continue;
            }else {
                s5 = s5+s6;
            }
        }
        char[] c2 = s5.toCharArray();
        for (char x:c2) {
            System.out.print(x);
        }
    }
}