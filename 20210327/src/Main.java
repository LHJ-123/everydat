import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Main {
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur!=null) {
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            RandomListNode node= map.get(cur);
            node.next=(cur.next == null)?null:map.get(cur.next);
            node.random=(cur.random == null)?null:map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}