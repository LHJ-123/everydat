import java.util.Stack;

//用栈实现队列
public class Demo {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public void push(int x) {
        while (!B.isEmpty()) {
            Integer top = B.pop();
            A.push(top);
        }
        A.push(x);
    }

    public int pop() {
        while (!A.isEmpty()) {
            Integer top = A.pop();
            B.push(top);
        }
        return B.pop();
    }

    public int peek() {
        while (!A.isEmpty()) {
            Integer top = A.pop();
            B.push(top);
        }
        return B.peek();
    }
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();
    }
}
