
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
    //合并两个有序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode index = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val<=cur2.val) {
                index.next = cur1;
                index = index.next;
                cur1 = cur1.next;
            }else {
                index.next = cur2;
                index = index.next;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            index.next = cur1;
            index = index.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            index.next = cur2;
            index = index.next;
            cur2 = cur2.next;
        }
        return newHead.next;

    }
}