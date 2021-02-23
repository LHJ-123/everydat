
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k<=0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = k;
        while (count>1) {
            if (fast.next!=null) {
                fast = fast.next;
            }else {
                return null;
            }
            count--;
        }
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
