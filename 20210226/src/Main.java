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
            RandomListNode index = new RandomListNode(cur.label);
            map.put(cur,index);
            cur = cur.next;
        }
        cur = pHead;
        while (cur!=null) {
            RandomListNode node = map.get(cur);
            node.next =(cur.next== null)?null:map.get(cur.next);
            node.random =(cur.random== null)?null:map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
    public RandomListNode Clone2(RandomListNode pHead){
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
