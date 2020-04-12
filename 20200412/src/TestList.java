import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C语言");
        list.add("C++");
        list.add("Python");
        //打印整个list
        System.out.println(list);
        //用下标访问
        //若当前List是ArrayList,访问下标是比较高效的
        //若是LinkedList,则是低效的
        System.out.println("===============");
        System.out.println(list.get(0));
        list.set(0,"go");
        System.out.println(list);
        //截取
        System.out.println("===============");
        System.out.println(list.subList(1,2));
        //重新构造一个List
        System.out.println("================");
        List<String> arrayList = new ArrayList<>(list);
        List<String> linkedList = new LinkedList<>(list);
        System.out.println(arrayList);
        System.out.println(linkedList);
        //强制转换（向下转型）
        ArrayList<String> arrayList1 = (ArrayList<String>)list;
        //不能 LinkedList<String> linkedList1 = (LinkedList<String>)list;

    }
}
