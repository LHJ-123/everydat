import java.util.Stack;

public class Main2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        if (stack1.empty()) {
            stack1.push(node);
            stack2.push(node);
        }else if (stack1.peek()>=node) {
            stack1.push(node);
            stack2.push(node);
        }else {
            stack1.push(node);
            stack2.push(stack2.peek());
        }

    }

    public void pop() {
        if (!stack1.empty()) {
            stack1.pop();
            stack2.pop();
        }

    }

    public int top() {
        if (!stack1.empty()) {
            return stack1.peek();
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
