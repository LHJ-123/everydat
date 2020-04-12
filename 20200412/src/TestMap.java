import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //put插入  通过key找value，反过来不行
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("行者"));
        //找到key  返回value  没找到，返回默认值武松
        System.out.println(map.getOrDefault("行者","武松"));
        System.out.println("==============");
        //contains   判定元素是否存在 containsKey比较高效推荐使用
        System.out.println(map.containsKey("及时雨"));
        System.out.println(map.containsValue("宋江"));
        //遍历   很少去遍历  Map里面的元素顺序和插入顺序无关 内部元素有自己的顺序
        System.out.println("==============");
        for(Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //清空
        System.out.println("==============");
        map.clear();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
