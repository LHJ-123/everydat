import java.util.ArrayList;
import java.util.List;

public class SynDB {
    List<String> list = new ArrayList<>();

    public SynDB(String s) {
        String[] s1 = s.split(",");
        for (int i = 0;i<s1.length;i++) {
            list.add(s1[i]);
        }
    }

    public static void main(String[] args) {
        String s = "";
        s = s+","+"sas";
        System.out.println(s);
    }
}
