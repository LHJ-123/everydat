import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    //字符流中的第一个不重复的字符
    Map<Character,Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        for (char ch:map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return '#';

    }
}
