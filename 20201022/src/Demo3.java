import java.util.Stack;

//括号匹配问题
public class Demo3 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            //比如字符串是"}",")","]"这种情况
            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            //比如字符串是"{",")"这种情况
            return false;
        }
        //比如字符串是"(",")"
        if (stack.empty()) {
            return true;
        }
        //比如字符串是"{","(",")"
        return false;
    }
}
