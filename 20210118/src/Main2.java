public class Main2 {
    public String replaceSpace(StringBuffer str) {
       StringBuilder s = new StringBuilder();
       for (int i = 0;i<str.length();i++) {
           char c = str.charAt(i);
           if (c == ' ') {
               s.append("%20");
           }else {
               s.append(c);
           }
       }
     return s.toString();
    }
    public String replaceSpace2(StringBuffer str) {
       return str.toString().replace(" ","%20");
    }
}
