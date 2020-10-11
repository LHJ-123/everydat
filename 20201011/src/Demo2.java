
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
//从尾到头打印链表
import java.util.ArrayList;
import java.util.Stack;

class ListNode1 {
         int val;
         ListNode next = null;

         ListNode1(int val) {
             this.val = val;
         }
     }


public class Demo2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> s = new Stack<>();
        ListNode cur = listNode;
        while(cur != null) {
            s.push(cur.val);
            cur =cur.next;
        }
        ArrayList<Integer> q = new ArrayList<>();
        while(!s.empty()) {
            q.add(s.pop());
        }
        return q;
    }
}