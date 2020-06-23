//day 20
import java.util.*;

public class Main {
    public static int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:gifts) {
            Integer count = map.get(i);
            if(count == null) {
                map.put(i,1);
            }else {
                map.put(i,count+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()>gifts.length/2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2};
        int ret = getValue(a,5);
        System.out.println(ret);
    }
}
