public class TestDemo {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
      /*  doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.display();*/

        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        //doubleLinkedList.addIndex(2,7);
        //doubleLinkedList.remove(1);
        doubleLinkedList.removeAllKey(1);
        doubleLinkedList.display();
    }
}
