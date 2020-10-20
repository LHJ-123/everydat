 //合并两个单链表
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Demo {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null && cur2 != null) {
            if(cur1.val>cur2.val) {
                tmp.next = cur2;
                tmp = tmp.next;
                cur2 = cur2.next;
            }else{
                tmp.next = cur1;
                tmp = tmp.next;
                cur1 = cur1.next;
            }
        }
        if(cur1 != null) {
            tmp.next = cur1;
        }
        if(cur2 != null) {
            tmp.next = cur2;
        }
        return newHead.next;
    }
}