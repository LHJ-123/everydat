import java.util.Arrays;

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo6 {
    public static void disPlay(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    public static Node removeKthNode(Node head, int k) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int k1 = count-k;
        Node prev = head;
        int count1 = 0;
        while (count1<k1-1) {
            prev = prev.next;
            count1++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node newHead = removeKthNode(node,2);
        disPlay(newHead);

    }
}
