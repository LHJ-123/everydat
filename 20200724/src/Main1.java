//day46 2
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //注意LinkedHashMap的使用，按输入顺序顺序输出
        Map<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            int a = scanner.nextInt();
            //注意\的转义
            String[] arr = s1.split("\\\\");
            String s2 = arr[arr.length-1];
            if(s2.length()>16) {
                s2 = s2.substring(s2.length()-16);
            }
            String key = s2+" "+a;
            //containsKey的使用
            if(map.containsKey(key)) {
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        int count = 0;
        //通过Map的Key遍历的使用
        //输出最后8位的方法
        for (String x:map.keySet()) {
            count++;
            if(count>(map.keySet().size()-8)) {
                System.out.println(x+" "+map.get(x));
            }
        }
    }
}
