public class MyStack {
    public ListNode head = new ListNode(-1);
    public void push(int value) {
        ListNode node = new ListNode(value);
        node.next = this.head.next;
        this.head.next = node;
    }
    public Integer pop() {
        ListNode toDelete = this.head.next;
        if (toDelete == null) {
            return null;
        }
        this.head.next = toDelete.next;
        return toDelete.val;
    }
    public Integer peek() {
        if (this.head.next == null) {
            return null;
        }
        return this.head.next.val;

    }
}
