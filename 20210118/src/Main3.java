import java.util.ArrayList;

class ListNode {
   public int val;
    public ListNode next = null;
    ListNode(int val) {
         this.val = val;
    }
}



public class Main3 {
/*    ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
    所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 list 即可得到逆序链表*/
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list1.add(listNode.val);
        }
        return list1;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l.next = l2;
        l2.next = l3;
        l3.next = l4;
        ArrayList<Integer> integers = printListFromTailToHead(l);
        System.out.println(integers);
        System.out.println(integers.get(0));
    }
}