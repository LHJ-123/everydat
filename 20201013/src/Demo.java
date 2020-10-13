class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo {
    //判断两个单链表是否相交
    public Node getIntersectionNode(Node headA,Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        Node pL = headA;
        Node pS = headB;
        while (pL != null) {
            pL = pL.next;
            count1++;
        }
        while (pS != null) {
            pS = pS.next;
            count2++;
        }
        pL = headA;
        pS = headB;
        int len = count1-count2;
        if (len<0) {
            pL = headB;
            pS = headA;
            len = count2-count1;
        }
        while (len>0) {
            pL = pL.next;
            len--;
        }
        while (pL !=null && pS != null && pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        while (pL != null && pL == pS) {
            return pL;
        }
        return null;
    }
}
