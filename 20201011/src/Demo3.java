class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo3 {
    //删除已排序好的链表中重复的结点且该结点不保留
    public Node deleteDuplication(Node head) {
        Node node = new Node(-1);
        Node tmp = node;
        Node cur = head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

    //判断是否为回文结构
    public boolean chkPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (head != slow) {
            if (head.data != slow.data) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //判断单链表中是否有环
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //将两个有序链表合成一个有序链表
    public Node mergeTwoLists(Node headA,Node headB) {
        Node newNode = new Node(-1);
        Node tmp = newNode;
        while (headA != null && headB != null) {
            if (headA.data<headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newNode.next;
    }
}
