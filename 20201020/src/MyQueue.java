public class MyQueue {
    //链表实现队列
    public ListNode head = new ListNode(-1);
    public ListNode tail = head;

    public void offer(int value) {
        ListNode node = new ListNode(value);
        tail.next = node;
        tail = tail.next;
    }

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

    public Integer peek() {
        if (this.head.next == null) {
            return null;
        }
        return this.head.next.val;
    }




}
