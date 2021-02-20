import java.util.ArrayList;

class ListNode {
      int val;
         ListNode next = null;

        ListNode(int val) {
        }
     }



public class Main4 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = listNode;
        while (cur != null) {
            list.add(0,cur.val);
            cur = cur.next;
        }
        return list;

    }
}