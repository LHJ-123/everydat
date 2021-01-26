import java.util.ArrayList;

public class Main4 {
    //字符串的排列
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        String cur = "";
        AllSituation(str,cur,list);
        return list;
    }

    private void AllSituation(String str, String cur, ArrayList<String> list) {
        if (str.length() == 0) {
            if (!list.contains(cur)) {
                list.add(cur);
            }
        }
        for (int i = 0;i<str.length();i++) {
            AllSituation(str.substring(0,i)+str.substring(i+1,str.length()),cur+str.charAt(i),list);
        }
    }
}
