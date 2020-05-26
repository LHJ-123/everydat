

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head;
    public MyLinkedList() {

    }

/*    public void addFirst(int data) {
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
    public void addIndex(int index,int data) {
        if (index<0 || index>size()) {
            System.out.println("位置不合法");
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size()) {
            addLast(data);
        }
        Node cur = this.head;
        Node node = new Node(data);
        int count = 0;
        while (count<index-1) {
            cur = cur.next;
            count++;
        }
        node.next = cur.next;
        cur.next = node;
    }

    private int size() {
        int count = 0;
        Node cur = this.head;
        while (cur!= null) {
            cur = cur.next;
            count++;
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
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        System.out.println("节点不存在");
    }
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
    }*/
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
    public void addIndex(int index,int data) {
        if (index<0 || index>size()) {
            System.out.println("位置不合法");
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
        Node cur = this.head;
        Node node = new Node(data);
        int count = 0;
        while (count<index-1) {
            cur = cur.next;
            count++;
        }
        node.next = cur.next;
        cur.next = node;
    }
    private int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
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
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node cur = this.head;
        while (cur .next!= null) {
            if (cur.next.data == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
        System.out.println("该节点不存在");
    }
    public void removeAllKey(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
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
