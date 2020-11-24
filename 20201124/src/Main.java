import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int cur = 0;
        for (int i = 0;i<s.length()-1;i++) {
                 if (s.charAt(i) == s.charAt(i+1) ||
                         s.charAt(i)+1 == s.charAt(i+1)) {
                     continue;
                 }else {
                     list.add(s.substring(cur,i+1));
                    // System.out.println(s.substring(cur,i+1)+" "+cur+" "+(i+1));
                     cur = i+1;
                 }
        }
        list.add(s.substring(cur));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        System.out.println(list.get(0));
    }
}
