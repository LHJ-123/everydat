import java.util.Scanner;
public class Main {
    public static boolean isHui(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //aba  b
            String a = in.nextLine();
            String b = in.nextLine();
            int count = 0;
            if (isHui(a+b)) {
                count++;
            }
            if (isHui(b+a)) {
                count++;
            }
            for (int i = 0;i<a.length()-1;i++) {
                String left = a.substring(0,i+1);
                String right = a.substring(i+1);
                String newS = left+b+right;
                if (isHui(newS)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}