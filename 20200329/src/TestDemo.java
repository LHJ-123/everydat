public class TestDemo {

    public static Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp =  newHead;
        while(headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
          if(headA != null) {
              tmp.next = headA;
          }
        if(headB != null) {
            tmp.next = headB;
        }
        //1、当两个单链表都不为空的时候

        //2、第一步完成后   其中一个单链表不为空  一个为空

        return newHead.next;
    }
    //判断两个单链表是否相交
    public static  Node getIntersectionNode(Node headA,Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int count1 = 0;
        int count2 = 0;
        Node pL = headA;
        Node pS = headB;
        while(pL != null) {
            pL = pL.next;
            count1++;
        }
        while(pS != null) {
            pS = pS.next;
            count2++;
        }
        pL = headA;
        pS = headB;
        int len = count1-count2;
        if(len<0) {
            pL = headB;
            pS = headA;
            len = count2-count1;
        }
        while(len > 0) {
            pL =pL.next;
            len--;
        }
        while(pL!= null && pS != null && pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        if(pL!= null  && pL == pS) {
            return pL;
        }
        return null;
    }
    public static void main(String[] args) {
        MyLinedList myLinedList1 = new MyLinedList();


        myLinedList1.addFirst(5);
        myLinedList1.addFirst(1);
        myLinedList1.addFirst(2);
        myLinedList1.addFirst(4);
        //myLinedList.addLast(5);
        myLinedList1.display();
        MyLinedList myLinedList2 = new MyLinedList();
        myLinedList2.addFirst(6);
        myLinedList2.addFirst(3);
        myLinedList2.addFirst(1);
        myLinedList2.addFirst(7);
        myLinedList2.display();
        /*Node ret = getIntersectionNode(myLinedList1.head,myLinedList2.head);
        System.out.println(ret.data);*/
     /*boolean x =  myLinedList.chkPalindrome();
        System.out.println(x);
*/
       /*Node ret =  myLinedList.deleteDuplication();
        myLinedList.reverseDisplay(ret);*/
        //Node ret = myLinedList.partition(3);
        //myLinedList.reverseDisplay(ret);
        //myLinedList.reverseDisplay(ret);
        // Node ret = myLinedList.reverseList1();
        //myLinedList.reverseDisplay(ret);
        //Node ret =  myLinedList.reverseList2();
        //  myLinedList.display();
        //myLinedList.reverseDisplay(ret);
    }
}
