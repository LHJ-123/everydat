class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode PupHead = new ListNode(-1);
    public ListNode last;

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.PupHead.next == null ) {
            this.PupHead.next = node;
            this.last = node;
            return ;
        }
         node.next = this.PupHead.next;
        this.PupHead.next.prev = node;
        this.PupHead.next = node;
        node.prev = null;

    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.last == null ) {
            this.PupHead.next = node;
            this.last = node;
            return ;
        }
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        if(index <0 || index >size()) {
            return;
        }
        if(index == 0) {
            addFirst(data);
        }
        if(index == size()) {
            addLast(data);
        }
        ListNode cur = this.PupHead.next;
        while(index > 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        node.prev =cur.prev;
        cur.prev = node;
        node.prev.next = node;

    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.PupHead.next;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return  false;
    }
//获取长度
    public int size(){
        ListNode cur = this.PupHead.next;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){

        if (key == this.PupHead.next.val) {
            this.PupHead.next = this.PupHead.next.next;

            return;
        }

        if (key == this.last.val) {
            this.last = this.last.prev;
            this.last.next = null;
            return;
        }

        ListNode cur = this.PupHead.next.next;
        while(cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur= cur.next;
        }

    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.PupHead.next;
        while(cur != null) {
            if (cur.val == key) {
                if (cur == this.PupHead.next) {
                    this.PupHead.next = this.PupHead.next.next;

                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = cur.prev;

                    }
                }
            }
            cur = cur.next;
        }
    }

    //打印
    public void display(){
        ListNode cur = this.PupHead.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
