public class Main4 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null&&list2 == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode prev = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1!=null&&cur2!=null) {
            if (cur1.val>=cur2.val) {
                prev.next =cur2;
                cur2 = cur2.next;
                prev = prev.next;
            }else {
                prev.next = cur1;
                cur1 = cur1.next;
                prev = prev.next;
            }
        }
        while (cur1!=null) {
            prev.next = cur1;
            cur1 = cur1.next;
            prev = prev.next;
        }
        while (cur2!=null) {
            prev.next = cur2;
            cur2 = cur2.next;
            prev = prev.next;
        }
        return newHead.next;
    }
}
