import java.util.HashMap;
import java.util.Map;

//找出只出现一次的数字

public class MapSetInterview {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        //System.out.println(map);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MapSetInterview interview = new MapSetInterview();
        int[] array = {1,2,1,2,3};
        int ret = interview.singleNumber(array);
        System.out.println("ret = "+ret);
    }
}
