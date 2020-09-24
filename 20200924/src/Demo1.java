
import java.util.Scanner;

public class Demo1 {
    public static String compressStr1(String s) {
        char[] c = s.toCharArray();
        char[] c1 = new char[s.length()];
        int[] x = new int[s.length()];
        int index = 0;
        int count = 1;
        for (int i = 0;i<c.length;i++) {
           if (i+1<c.length && c[i] == c[i+1]) {
               count++;
               continue;
           }else {
               c1[index] = c[i];
               x[index] = count;
               index++;
               count = 1;
           }
        }
        String s1 = "";
        for (int i = 0;i<index;i++) {
            s1 = s1+c1[i]+x[i];
        }
       return s1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = compressStr1(s);
        System.out.println(s1);
    }
}
