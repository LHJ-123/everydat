import java.util.*;

public class Demo4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0;i<a.length;i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        List<String> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<a.length;i++) {
            if (b[i] == 1) {
                continue;
            }else {
                map.put(a[i],b[i]);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getKey() == 1) {
                String s = "";
                s = s+entry.getKey()+"->"+entry.getValue();
                Integer x = map.get(entry.getValue());
                int count = 1;
                while (x != null && count<m-1 ) {
                    s = s+"->"+x;
                    x = map.get(x);
                   count++;
                }
                s = s+"->1";
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
