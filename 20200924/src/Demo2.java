import java.util.Scanner;

public class Demo2 {
    public static int StrToInt(String s) {
        char[] c = s.toCharArray();
        for (int i = 0;i<c.length;i++) {
            if (c[i]>='0'&&c[i]<='9') {
                continue;
            }else {
                return 0;
            }
        }
        if (s == null || s.length() == 0) {
            return 0;
        }
        double sum = 0;
        int size = s.length();
        for (int i = 0;i<size;i++) {
            sum = sum+c[i]*Math.pow(10,size-1-i);
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (sum>max) {
            return max;
        }
        if (sum<min) {
            return min;
        }
        int cur = (int)sum;
        return cur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int x = StrToInt(s);
        System.out.println(x);
    }
}
