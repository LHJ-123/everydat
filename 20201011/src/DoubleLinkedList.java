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
    public DoubleLinkedList(ListNode head, ListNode last) {
        this.head = head;
        this.last = last;
    }

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null){
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
        if (this.head == null) {
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
        if (index<0 || index>size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size()) {
            addLast(data);
        }
        ListNode cur = this.head;
        if (index>0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }

    private int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }



}
