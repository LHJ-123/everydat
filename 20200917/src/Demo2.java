import java.util.HashMap;
import java.util.Map;

//找只出现一次的两个数
public class Demo2 {
    public static int a = 0;
    public static int b = 0;
    public static void findOneNum(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:array) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() == 1) {
                if (a == 0) {
                    a = entry.getKey();
                    continue;
                }
                if (b == 0) {
                    b = entry.getKey();
                    break;
                }
            }
        }
        System.out.println(a+" "+b);
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,1,3,5,9};
        findOneNum(array);
    }
}
