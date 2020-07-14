import java.util.*;
//day38 1
public class Main2 {
    public int getLCA(int a, int b) {
        // write code here
        if(a == b) {
            return a;
        }
        return a>b?getLCA(a/2,b):getLCA(a,b/2);
    }
}