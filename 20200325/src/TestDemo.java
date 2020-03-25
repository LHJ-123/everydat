public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        /*myLinedList.addFirst(1);
        myLinedList.addFirst(2);
        myLinedList.addFirst(3);
        myLinedList.addFirst(4);*/

        myLinedList.addLast(1);
        myLinedList.addLast(1);
        myLinedList.addLast(3);
        myLinedList.addLast(4);
        myLinedList.addLast(1);
       // myLinedList.remove(2);
        myLinedList.removeAllKey(1);
        myLinedList.display();
       /* System.out.println(myLinedList.contains(4));
        System.out.println(myLinedList.size());
        myLinedList.addIndex(0,1);
        myLinedList.addIndex(5,5);
        myLinedList.addIndex(3,5);
        myLinedList.display();*/
    }
}
