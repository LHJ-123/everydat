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

public class Main2 {
    //复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead){
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            map.put(p,node);
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            RandomListNode m = map.get(p);
            m.next = (p.next == null)?null:map.get(p.next);
            m.random = (p.random == null)?null:map.get(p.random);
            p = p.next;
        }
        return map.get(pHead);
    }
}