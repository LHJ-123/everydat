//day 26 2
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            String[] people = new String[num];
            for(int i = 0;i<num;i++) {
                people[i] = in.next();
            }
            int num1 = in.nextInt();
            String[] people1 = new String[num1];
            for(int i = 0;i<num1;i++) {
                people1[i] = in.next();
            }
            Map<String,Integer> map = new HashMap<>();
            for(String x:people1) {
                Integer count = map.get(x);
                if(count == null) {
                    map.put(x,1);
                }else {
                    map.put(x,count+1);
                }
            }
            // Integer d = null;
            int y = 0;
            for(Map.Entry<String,Integer> entry:map.entrySet()) {
                //d = d+entry.getValue();

                for(int i = 0;i<num;i++) {
                    if(people[i].equals(entry.getKey())) {
                        System.out.println(entry.getKey()+" "+":"+" "+entry.getValue());
                        y = y+entry.getValue();
                    }
                }
            }
            int y1 = num1-y;
            System.out.println("Invalid"+" "+":"+" "+y1);
        }
    }
}