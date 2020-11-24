import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<A.length();i++) {
            if (A.charAt(i) != '(' && A.charAt(i) != ')' ) {
                return false;
            }
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            if (A.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
