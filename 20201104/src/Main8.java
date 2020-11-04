import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int count = 0;
        while (s1.contains(s2)) {
            count++;
            int index = s1.indexOf(s2);
            s1 = s1.substring(s2.length()+index);
        }
        System.out.println(count);
    }
}
