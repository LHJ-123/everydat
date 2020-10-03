//对单链表进行插入排序
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo {
    public static void disPlay(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    public static Node insertList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node aux = new Node(-1);
        aux.next = head;
        while (cur!=null) {
            if (cur.data<pre.data) {
                pre.next = cur.next;
                Node l1 = aux;
                Node l2 = aux.next;
                while (cur.data>l2.data) {
                    l1 = l2;
                    l2 = l2.next;
                }
                cur.next = l2;
                l1.next = cur;
                cur = pre.next;
            }else {
                pre = cur;
                cur =  cur.next;
            }
        }
        return aux.next;
    }

    public static void main(String[] args) {
        Node node = new Node(9);
        Node node1 = new Node(5);
        Node node2 = new Node(18);
        Node node3 = new Node(2);
        Node node4 = new Node(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node newHead = insertList(node);
        disPlay(newHead);

    }

}
