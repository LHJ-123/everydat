import java.util.*;


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main1 {
    public ListNode partition(ListNode pHead, int x) {
        ListNode a = null;
        ListNode b = null;
        ListNode c = null;
        ListNode d = null;
        while(pHead != null) {
            if(pHead.val<x){
                if(a == null) {
                    a = pHead;
                    b = pHead;
                }else {
                    b.next = pHead;
                    b = b.next;
                }
            }else {
                if(c == null) {
                    c = pHead;
                    d = pHead;
                }else {
                    d.next = pHead;
                    d = d.next;
                }
            }
            pHead = pHead.next;
        }
        if(a == null&&c != null) {
            return c;
        }
        if(a!= null&&c == null) {
            return a;
        }
        if(a!=null&&c!=null) {
            b.next = c;
            d.next = null;
            return a;
        }
        return null;
    }
}
