//day46 1
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:array) {
            Integer count = map.get(x);
            if(count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()>array.length/2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int ret = MoreThanHalfNum_Solution(arr);
        System.out.println(ret);

    }
}