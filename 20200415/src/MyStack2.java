class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
//基于链表，链表头部表示栈顶，尾部表示栈底
public class MyStack2 {

    Node head = new Node(-1);
    //头插
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head.next;
        this.head.next = newNode;

    }
    //头删
    public Integer pop() {
        Node toDelete = this.head.next;
        if (toDelete == null) {
            return null;
        }
        this.head.next = toDelete.next;
        return toDelete.val;

    }
    //取表头的下一个结点
    public Integer peek() {
        if (this.head.next == null) {
            return null;
        }
        return this.head.next.val;


    }

}
