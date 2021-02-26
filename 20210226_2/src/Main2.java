import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main2 {
    public String PrintMinNumber(int [] numbers) {
        String result = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        for (int i:list) {
            result+=i;
        }
        return result;

    }
}
