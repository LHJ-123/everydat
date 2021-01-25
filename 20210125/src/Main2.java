import java.util.Stack;

public class Main2 {
    //栈的压入，弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA.length == 0 || pushA.length == 0 || popA.length!=pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i<pushA.length;i++) {
            stack.push(pushA[i]);
            while (!stack.empty()&&stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();


    }
}
