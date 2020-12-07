import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<10;i++) {
            arr[i] = scanner.nextInt();
            map.put(i,arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            Integer cur = entry.getValue();
            while (cur != 0) {
                list.add(entry.getKey());
                cur--;
            }
        }
        Collections.sort(list);
        String s = String.valueOf(list);
        s = s.replace(",","");
        s = s.substring(1,s.length()-1);
        s= s.replace(" ","");
        if (arr[0] != 0) {
            String s1 = s.substring(arr[0],arr[0]+1)+s.substring(0,arr[0])+s.substring(arr[0]+1);
           System.out.println(s1);
            return;
        }else {
            System.out.println(s);
        }

    }
}
