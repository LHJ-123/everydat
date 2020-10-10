class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo3 {
    public void addFirst(int data,Node head) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    //头插法翻转单链表
    public Node reverseList(Node head) {
        int num = head.data;
        Node cur = head.next;
        while (cur != null) {
            addFirst(cur.data,head);
            cur = cur.next;
        }
        Node s = head;
        while (s != null) {
            if (s.data == num) {
                s.next = null;
                break;
            }
            s = s.next;
        }
        return head;
    }

    //返回链表中间节点
    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public int size(Node head) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //返回倒数第K个节点
    public Node FindKthToTail(int k,Node head) {
        if (k<=0 || k>size(head)) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        int i = 0;
        while (i<k-1) {
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //以给定的x为分割线，小于x的排在大于等于x的数之前，原来数的序列保持不变
    public Node partition(int x,Node head) {
        Node cur = head;
        Node as = null;
        Node ae = null;
        Node bs = null;
        Node be = null;
        while (cur != null) {
            if (cur.data<x) {
                if (as == null) {
                    ae = cur;
                    as = ae;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }else {
                if (bs == null) {
                    be = cur;
                    bs = be;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }
            cur = cur.next;
        }
        if (as == null) {
            return bs;
        }else {
            ae.next = bs;
            if (bs != null) {
                be.next = null;
            }
            return as;
        }
    }
}
