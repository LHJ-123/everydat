  class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
public class Main2 {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return null;
        }
        ListNode cur = pHead;
        int count = 0;
        while (cur!=null) {
            cur = cur.next;
            count++;
        }
        if (k<1||k>count) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (k>1) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
