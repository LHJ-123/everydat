//day31 2
//原题没有通过但一些思想还是得重新温习一下
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            int pos = 0;
            for(int i = 0;i<s.length();i++) {
                if(s.charAt(i) == '\\') {
                pos = i;
            }
        }
        String s1 = s.substring(pos+1);
        if(s1.length()>16) {
            int pos1 = s1.length()-16;
            s1 = s1.substring(pos1);
        }
        Integer count = map.get(s1);
        if(count == null) {
            map.put(s1,1);
        }else {
            map.put(s1,count+1);
        }
        if(map.size()>8) {
            break;
        }
    }
  List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if(count1 == count2) {
                    return count1-count2;
                }
                return count2-count1;
            }
        });

        for(String x : list) {
        System.out.println(x+" "+map.get(x));
    }
}
}