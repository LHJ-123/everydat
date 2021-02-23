public class Main4 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null&&list2 == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode index = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1!=null&&cur2!=null) {
            if (cur1.val>cur2.val) {
                index.next = cur2;
                index = index.next;
                cur2 = cur2.next;
            }else if (cur1.val<=cur2.val) {
                index.next = cur1;
                index = index.next;
                cur1 = cur1.next;
            }
        }
        while (cur1!=null) {
            index.next = cur1;
            index = index.next;
            cur1 = cur1.next;
        }
        while (cur2!=null) {
            index.next = cur2;
            index = index.next;
            cur2 = cur2.next;
        }
        return newHead.next;

    }
}
