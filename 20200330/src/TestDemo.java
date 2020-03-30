public class TestDemo {

    public static Node mergeTwoLists(Node headA,Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;

        while(headA != null && headB != null) {
            if(headA.data > headB.data) {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }else {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            }
        }
        if(headA == null) {
            tmp.next = headB;
        }
        if(headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
        /*MyLinedList myLinedList1 = new MyLinedList();
        myLinedList1.addFirst(1);
        myLinedList1.addFirst(2);
        myLinedList1.addFirst(3);
        myLinedList1.addFirst(4);
        myLinedList1.addFirst(6);
        myLinedList1.display();
        MyLinedList myLinedList2 = new MyLinedList();
        myLinedList2.addFirst(12);
        myLinedList2.addFirst(123);
        myLinedList2.addFirst(130);
        myLinedList2.addFirst(234);
        myLinedList2.display();
        Node ret = mergeTwoLists(myLinedList1.head,myLinedList2.head);
        myLinedList1.reverseDisplay(ret);*/
       DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
       doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(5);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(4);
        doubleLinkedList.display();
        //doubleLinkedList.remove(1);
        doubleLinkedList.removeAllKey(4);
        doubleLinkedList.display();
    }
}
