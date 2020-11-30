import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            int cur = 0;
            while (cur<=n-1) {
                list.add(cur);
                cur++;
            }
            int i = 0;
            while (list.size()>1) {
                i = (i+2)%list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));

        }
    }
}

