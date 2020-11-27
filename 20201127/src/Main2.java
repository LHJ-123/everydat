import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            Integer ret = map.get(a);
            if (ret == null) {
                map.put(a,1);
            }else {
                map.put(a,ret+1);
            }
            count++;
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue()>=count/2) {
                System.out.println(entry.getKey());
            }
        }
    }
}
