
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.length()>1000) {
            return;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i<s.length();i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),count+1);
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });
        for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i)+":"+map.get(list.get(i)));
        }

    }
}