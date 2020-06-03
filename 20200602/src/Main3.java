
import java.util.Scanner;
public class Main3 {
    public static boolean isSame(char a,String s) {
        for(int i = 0;i<s.length();i++) {
            if(a == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String q = "";
        for(int i = 0;i<s1.length();i++) {
            if(isSame(s1.charAt(i),s2)) {
                 s1 = removeCharAt(s1,i);
                 i = i-1;
            }
        }
        System.out.println(s1);
    }
}
