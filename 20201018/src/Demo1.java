 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Demo1 {
    public int size(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k == 0 || k>size(head)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while(i<k-1) {
            fast = fast.next;
            i++;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}