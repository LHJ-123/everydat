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


    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.last == null) {
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    public void addIndex(int index,int data) {
        ListNode node = new ListNode(data);
        if (index<0||index>size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size()) {
            addLast(data);
        }
        ListNode cur = this.head;
        while (index>0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }

    public void remove(int key) {
        if (key == this.head.val) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        if (key == this.last.val) {
            this.last = this.last.prev;
            this.last.next = null;
            return;
        }
        ListNode cur = this.head.next;
        while (cur!=null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
    }

    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur!=null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next!= null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur!=null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}
