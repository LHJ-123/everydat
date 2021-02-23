public class Main3 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next  =prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
