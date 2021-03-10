public class Main4 {
    public String ReverseSentence(String str) {
        if (str == null||str.length() == 0||str.trim().equals("")) {
            return str;
        }
        String[] s = str.split(" ");
        String s1 = "";
        for (int i = s.length-1;i>=0;i--) {
            if (i != 0) {
                s1 = s1+s[i]+" ";
            }else {
                s1 = s1+s[i];
            }
        }
        return s1;
    }
}
