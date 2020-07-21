//day43 1
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWSYZ1234567890";
        String s2 = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0;i<n;i++) {
                String s3 = scanner.next();
                s3 = s3.replace("-","");
                String s4 = "";
                for (int j = 0;j<7;j++) {
                    s4 = s4+s2.charAt(s1.indexOf(s3.charAt(j)+""));
                }
                s4 = s4.substring(0,3)+"-"+s4.substring(3,7);
                if (!list.contains(s4)) {
                    list.add(s4);
                }
            }
            Collections.sort(list);
            for (int i = 0;i<list.size();i++) {
                System.out.println(list.get(i));
            }
            System.out.println();
        }
    }
}
