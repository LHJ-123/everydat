import java.util.ArrayList;

public class Main3 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0||str == null) {
            return list;
        }
        String path = "";
        findAll(list,str,path);
        return list;
    }

    private void findAll(ArrayList<String> list, String str, String path) {
        if (str.length() == 0) {
            if (!list.contains(path)) {
                list.add(path);
            }
        }
        for (int i = 0;i<str.length();i++) {
            findAll(list,str.substring(0,i)+str.substring(i+1,str.length()),path+str.charAt(i));
        }

    }
}
