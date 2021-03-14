import java.util.LinkedHashMap;
import java.util.Map;

public class Main5 {
    //Insert one char from stringstream
    Map<Character,Integer> map = new LinkedHashMap<>();
    public void Insert(char ch) {
        if (map.containsKey(ch)) {

            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char c:map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
