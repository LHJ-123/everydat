import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("JAVA");
        set.add("JAVA");
        set.add("JAVA");
        set.add("C++");
        set.add("Python");
        set.add("JS");
        //判定某个元素是否再set中存在
        System.out.println(set.contains("JAVA"));
        //删除元素
        set.remove("C++");
        System.out.println(set.contains("C++"));
        System.out.println(set);
        //可以帮助我们进行去重
        //foreach遍历set    是迭代器的简化版本
        for (String s:set) {
            System.out.println(s);
        }
        //使用迭代器来遍历集合类
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
//set和Map里面的元素的顺序和插入顺序无关
//只有实现了iterable的对象才可以使用for each遍历