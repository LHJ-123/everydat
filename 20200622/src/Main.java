import java.util.*;
//day 19
public class Main {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] a = new boolean[n];
        for(int i = 0;i<n;i++) {
            a[i] = s.contains(p[i]);
        }
        return a;
    }
}
