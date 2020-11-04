import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        if (s1.contains(s2)) {
            System.out.println(s1.indexOf(s2));
        }else {
            System.out.println(-1);
        }
    }
}
