import java.util.*;

public class Main {
    public boolean isKuo (String s) {
        int a = s.length();
        for(int i = 0;i<a;i++) {
            if(s.charAt(i) != '('&&s.charAt(i) != ')') {
                return false;
            }
        }
        return true;
    }
    public boolean chkParenthesis(String A, int n) {
        Stack q = new Stack();
        if(!isKuo(A)) {
            return false;
        }else {

            for(int i = 0;i<n;i++) {
                if(A.charAt(i) == '(') {
                    q.push(A.charAt(i));

                }
                if(A.charAt(i) == ')') {
                    if(q.empty()) {
                        return false;
                    }

                    q.pop();
                }
            }
            if(q.empty()) {
                return true;
            }else {
                return false;
            }
        }
    }
}
