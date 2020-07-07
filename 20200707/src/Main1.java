//day32 2
import java.util.*;

public class Main1 {
    public static int countNumberOf2s(int n) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<=n;i++) {

            while (i!=0) {
                list.add(i%10);
                i = i/10;
            }
        }
        int count = 0;
        for (Integer a :list) {
            if (a == 2) {
                count++;
            }else {
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = countNumberOf2s(n);
        System.out.println(ret);
    }
}