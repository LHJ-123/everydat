
  class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main6 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null||pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null &&fast.next!=null) {
            fast = fast.next.next;
            slow =slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow!=slow2) {
                    slow  = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}