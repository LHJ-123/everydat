
public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();


        myLinedList.addFirst(5);
        myLinedList.addFirst(2);
        myLinedList.addFirst(1);
        myLinedList.addFirst(4);
        //myLinedList.addLast(5);

        myLinedList.display();

        Node ret = myLinedList.partition(3);
       //myLinedList.reverseDisplay(ret);
        myLinedList.reverseDisplay(ret);
       // Node ret = myLinedList.reverseList1();
        //myLinedList.reverseDisplay(ret);
       //Node ret =  myLinedList.reverseList2();
      //  myLinedList.display();
       //myLinedList.reverseDisplay(ret);
    }
}



