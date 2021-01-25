import java.util.Stack;

public class Main {
    //包含min函数的栈
    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> getMin = new Stack<>();
    public void push(int node) {
        if (stack.empty()) {
            getMin.push(node);
            stack.push(node);
            return;
        }
        if (node<getMin.peek()) {
            getMin.push(node);
            stack.push(node);
        }else {
            getMin.push(getMin.peek());
            stack.push(node);
        }

    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        stack.pop();
        getMin.pop();

    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();

    }

    public int min() {
        if (getMin.empty()) {
            return -1;
        }
        return getMin.peek();

    }
}
