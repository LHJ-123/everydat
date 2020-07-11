import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,5);
        map.put(4,7);
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> entry = iterator.next();
            if ((entry.getKey()).equals(4)) {
                iterator.remove();
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer,Integer> entry = iterator1.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
