
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main3 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null||pHead2 == null) {
            return null;
        }

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1!=cur2) {
            cur1 = cur1!=null?cur1.next:pHead2;
            cur2 = cur2!=null?cur2.next:pHead1;
        }
        return cur1;
    }
}
