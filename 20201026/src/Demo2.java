import java.util.LinkedList;
import java.util.Queue;


//用队列实现栈
public class Demo2 {
    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();

    public void push(int x) {
        A.offer(x);
    }

    public int pop() {
        while (A.size()>1) {
            Integer cur = A.poll();
            B.offer(cur);
        }
        int top = A.poll();
        //交换A,B
        swapAB();

        return top;

    }
    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }
    public int top() {
        while (A.size() > 1) {
            Integer cur = A.poll();
            B.offer(cur);

        }
        int top = A.poll();
        //并不是真的要出栈它，只是为了取栈顶元素，还需要加回去
        B.offer(top);
        //交换A,B
        swapAB();

        return top;
    }
    public boolean empty() {
        return A.isEmpty()&&B.isEmpty();

    }
}
