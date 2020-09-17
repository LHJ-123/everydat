//单链表回顾

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class Demo3 {
    public Node head;

    public Demo3(Node head) {
        this.head = null;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;

    }

    //任意位置插入
    public void addIndex(int index,int data){
        if (index<0 || index>size()) {
            System.out.println("插入的位置不合法");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        int count = 0;
        Node node = new Node(data);
        Node prev = this.head;
        while (count<index-1) {
            prev = prev.next;
            count++;
        }
        node.next = prev.next;
        prev.next = node;
    }

    private int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                prev.next = prev.next.next;
                return;
            }
            prev = prev.next;
        }
        System.out.println("节点不存在");
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

}
