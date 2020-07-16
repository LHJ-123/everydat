import java.util.Scanner;
//day 39 2
public class Main1 {
    public static boolean isMos(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            for (int i = 0;i<=s.length();i++) {
                StringBuilder sb = new StringBuilder(s);
                StringBuilder sb2 = sb.deleteCharAt(i);
                if (isMos(sb2.toString())) {
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
        }
    }
}
