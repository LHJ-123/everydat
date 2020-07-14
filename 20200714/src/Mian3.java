import java.util.*;
//day38 2
public class Mian3 {
    public String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer s = new StringBuffer();
        for(int i = 0;i<length;i++) {
            if(iniString.charAt(i) == ' ') {
                s.append("%20");
            }else {
                s.append(iniString.charAt(i));
            }
        }
        return s.toString();
    }
}