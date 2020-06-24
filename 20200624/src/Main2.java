import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            func(s);
        }
    }

    private static void func(String s) {
        for (int i = 0;i<s.length();i++) {
            char ret = s.charAt(i);
            if (ret>='A') {
                ret = (char)(ret>'E'?ret-5:ret+21);
            }
            System.out.print(ret);
        }
        System.out.println();
    }
}
