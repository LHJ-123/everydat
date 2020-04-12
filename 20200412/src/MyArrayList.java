import org.omg.CORBA.Object;

class Student{
    public String name;
    public String sex;
}

public class MyArrayList<E> {
    //E[] array = new E[100];这种初始化是不行的
    public E[] array = (E[])new Object[10];
    public int size ;

     public void add(E o) {
        array[size] = o;
        size++;
    }
    E get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        /*MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("我");
        myArrayList.add("爱");
        myArrayList.add("Java");
        String ret = (String)myArrayList.get(0);
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(new Student());
        myArrayList1.add(new Student());
        myArrayList1.add(new Student());*/
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("hehe");
        String s = myArrayList.get(0);
        MyArrayList<Student> myArrayList1 = new MyArrayList<>();
        myArrayList1.add(new Student());
        Student student = myArrayList1.get(0);

    }
}
