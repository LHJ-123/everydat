import java.util.Stack;

public class Main2 {
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        if (stack.empty()) {
            stack.push(node);
            stack2.push(node);
        }else if (stack.peek()>=node) {
            stack.push(node);
            stack2.push(node);
        }else {
            stack.push(node);
            stack2.push(stack2.peek());
        }

    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        stack.pop();
        stack2.pop();
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;

    }

    public int min() {
        if (!stack2.empty()) {
            return stack2.peek();
        }
        return -1;
    }
}
