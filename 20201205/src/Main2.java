

import java.util.*;
public class Main2{
    public static String[] getGray(int n) {
        if(n == 1) return new String[] {"0", "1"};
        String[] s = getGray(n - 1);
        String[] res = new String[s.length * 2];
        for (int i = 0; i < s.length; i ++) {
            res[i] = "0" + s[i];
            res[s.length + i] = "1" + s[s.length - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = getGray(3);
        for (String a:s){
            System.out.print(a+" ");
        }
    }
}