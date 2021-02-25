import java.util.Stack;

public class Main3 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0||popA.length == 0||popA.length!=pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i<pushA.length;i++) {
            stack.push(pushA[i]);
            while (!stack.empty()&&popA[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
