import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //size和ieEmpty
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        collection.add("我");
        collection.add("爱");
        collection.add("Java");
        System.out.println("==============");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println("==============");
        //集合转数组   Object是所有类的父类，也相当于String
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //要遍历，要用for或者while,需要搭配迭代器
        System.out.println("==============");
        for(String s:collection) {
            System.out.println(s);
        }
        //判定某个元素是否存在  contains是按值比较的，不是身份
        System.out.println("==============");
        boolean ret = collection.contains("我");
        System.out.println(ret);
        //删除
        System.out.println("==============");
        collection.remove("我");
        for(String s:collection) {
            System.out.println(s);
        }
        //清空
        System.out.println("==============");
        collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

    }
}
