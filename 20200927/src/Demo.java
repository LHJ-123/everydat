import java.util.Scanner;
//找出字符串中数字的个数
public class Demo {
    public  int numCount(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        for (char x:c) {
            if (x>='0' && x<='9') {
                count++;
            }
        }
        return count;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int m = numCount(s);
        System.out.println(m);
    }*/
}
