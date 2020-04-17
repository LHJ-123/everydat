import java.util.Stack;


//用栈实现队列

public class MyQueue {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!B.isEmpty()) {
            Integer top = B.pop();
            A.push(top);
        }
        A.push(x);

    }

    public int pop() {
        if (empty()) {
            return 0;
        }
        while (!A.isEmpty()) {
            Integer top = A.pop();
            B.push(top);
        }
        return B.pop();

    }

    public int peek() {
        if (empty()) {
            return 0;
        }
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
