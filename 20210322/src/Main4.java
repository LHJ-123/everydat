import java.util.ArrayList;

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
            this.val = val;
        }
     }



public class Main4 {
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode newHead = null;
        ListNode prev = new ListNode(-1);
        prev.next = listNode;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        while (newHead != null) {
            list.add(newHead.val);
            newHead = newHead.next;
        }
        return list;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode!=null) {
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}