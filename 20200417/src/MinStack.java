import java.util.Stack;

//实现最小栈

public class MinStack {
    //A是按正常栈存储元素
    //B是A中对应情况下的最小值
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
//A 和 B中的元素要同步变化
    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if (B.empty()) {
            B.push(x);
            return;

        }
        int min = B.peek();
        if (x <min) {
            min = x;
        }
        B.push(min);

    }

    public void pop() {
        if (A.empty()) {
            return;
        }
        A.pop();
        B.pop();

    }

    public int top() {
        if (A.empty()) {
            return 0;
        }
        return A.peek();

    }

    public int getMin() {
        if (B.empty()) {
            return 0;
        }
        return B.peek();

    }
}
