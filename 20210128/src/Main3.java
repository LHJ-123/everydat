public class Main3 {
    //第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (str.indexOf(t) == i && str.lastIndexOf(t) == i) {
                return i;
            }
        }
        return -1;
    }
}