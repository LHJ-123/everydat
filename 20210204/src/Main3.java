public class Main3 {
    //删除链表中重复节点
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null||pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        while (cur!=null) {
            if (cur.next!=null&&cur.next.val == cur.val) {
                while (cur.next!=null&&cur.next.val == cur.val){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else {
                pre =cur;
                cur  = cur.next;
            }
        }
        return newHead.next;


    }
}
