public class Main3 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null||str.length() == 0) {
            return -1;
        }
        for (int i = 0;i<str.length();i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == i&&str.lastIndexOf(c) == i) {
                return i;
            }
        }
        return -1;

    }
}
