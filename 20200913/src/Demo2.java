import java.util.HashMap;
import java.util.Map;

public class Demo2 {
    public  int findManyNum(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:array) {
            Integer count = map.get(x);
            if(count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue()>array.length/2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /*public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int n = findManyNum(array);
        System.out.println(n);
    }*/
}
