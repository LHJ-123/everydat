import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static String compressStr(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (char x:c) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        String s1 = "";
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            s1 = s1+entry.getKey()+entry.getValue();
        }
        return s1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = compressStr(s);
        System.out.println(s1);
    }
}
