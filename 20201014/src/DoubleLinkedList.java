class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode head;
    public ListNode last;

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head.val == key) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        if (this.last.val == key) {
            this.last = this.last.prev;
            this.last.next = null;
            return;
        }
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (this.head == cur) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
}
