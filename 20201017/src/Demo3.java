import java.util.Scanner;

public class Demo3 {
    public static String getZodiac(int n) {
        int cur = n+9;
        if (cur%12 == 1) {
            return "鼠";
        }
        if (cur%12 == 2) {
            return "牛";
        }
        if (cur%12 == 3) {
            return "虎";
        }
        if (cur%12 == 4) {
            return "兔";
        }
        if (cur%12 == 5) {
            return "龙";
        }
        if (cur%12 == 6) {
            return "蛇";
        }
        if (cur%12 == 7) {
            return "马";
        }
        if (cur%12 == 8) {
            return "羊";
        }
        if (cur%12 == 9) {
            return "猴";
        }
        if (cur%12 == 10) {
            return "鸡";
        }
        if (cur%12 == 11) {
            return "狗";
        }
        if (cur%12 == 0) {
            return "猪";
        }
      return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = getZodiac(n);
        System.out.println(s);
    }
}
