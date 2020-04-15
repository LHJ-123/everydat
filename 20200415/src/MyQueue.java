class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyQueue {
    //也可以使用链表和顺序表实现
    //先用链表实现（更简单一些）
    //链表尾部作为队尾，方便插入。头部作为队首，方便删除
    //为了更方便实现尾部插入，多搞一个引用指向尾部
    public ListNode head = new ListNode(-1);
    public ListNode tail = head;
    //入队列（链表尾插）
    public void offer(int value) {
        ListNode newListNode = new ListNode(value);
        tail.next = newListNode;
        tail = tail.next;

    }
    //出队列（链表头删）
    public Integer poll() {
        ListNode toDelete = this.head.next;
        if (this.head.next == null) {
            return null;
        }

        this.head.next = toDelete.next;
        if (this.head.next == null) {
            tail = this.head;

        }
        return toDelete.val;
    }
    //取队首
    public Integer peek() {
        if (this.head.next == null) {
            return null;
        }
        return this.head.next.val;

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        Integer cur = null;
        while ((cur = myQueue.poll()) != null) {
            System.out.println(cur);
        }
    /*    while (true) {
            Integer cur = myQueue.poll();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }*/

    }
}
