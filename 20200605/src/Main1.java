import java.util.Stack;

public class Main1 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()) {
            Integer top = stack2.pop();
            stack1.push(top);
        }
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()&&stack1.empty()) {
            return 0;
        }
        while(!stack1.empty()) {
            Integer top = stack1.pop();
            stack2.push(top);
        }
        return stack2.pop();
    }
}
