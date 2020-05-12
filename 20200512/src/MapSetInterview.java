import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}
public class MapSetInterview {
    //采用按位异或解决只出现一次数的问题
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int x:nums) {
            ret^=x;         //a^b^b=a
        }
        return ret;
    }

    //深拷贝拷贝链表
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        for (Node cur = head;cur!=null;cur=cur.next) {
            map.put(cur,new Node(cur.val));
        }
        for (Node cur = head;cur!=null;cur=cur.next) {
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }
        return map.get(head);
    }
    public int numJeweIsInStones1(String J,String S) {
        int count = 0;
        for (int i = 0;i<S.length();i++) {
            char c = S.charAt(i);
            if (J.contains(c+"")) {   //转为字符串
                count++;
            }
        }
        return count;

    }
    //改进
    //TreeSet.contains时间复杂度O(logn)
    //HashSet.contains时间复杂度O(1)
    public int numJeweIsInStones(String J,String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0;i<J.length();i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0;i<S.length();i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;

    }
    //前k个高频单词
    public List<String> topKFrequent(String[] words,int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String x:words) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x,1);
            }else {
                map.put(x,value+1);
            }
            List<String> result = new ArrayList<>(map.keySet());
            Collections.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    //在这个匿名内部类里面可以访问到上面的map变量
                    int count1 = map.get(o1);
                    int count2 = map.get(o2);
                    if (count1 == count2) {
                        return o1.compareTo(o2);//默认字典序
                    }
                    return count2-count1;
                }
            });
            //取前K个
            return result.subList(0,k);
        }
    }

}
