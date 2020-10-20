//反转单链表
public class Demo1 {
    public ListNode ReverseList(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead =  cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}