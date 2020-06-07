import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] strs = in.nextLine().split(" ");

            int[] a = new int[strs.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.valueOf(strs[i]);
            }

            Map<Integer,Integer> map = new HashMap<>();
            for(int x:a) {
                Integer count = map.get(x);
                if(count == null) {
                    map.put(x,1);
                }else {
                    map.put(x,count+1);
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
                if(entry.getValue()>=a.length/2) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
