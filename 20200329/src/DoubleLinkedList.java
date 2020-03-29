 class ListNode {
    int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode head;
    public ListNode last;
    public DoubleLinkedList(ListNode head, ListNode last) {
        this.head = head;
        this.last = last;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
      if(this.head == null ) {
          this.head = node;
          this.last = node;
          return ;
      }
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.last == null ) {
            this.head = node;
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
     ListNode cur = this.head;
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
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public void display(){

    }
    public void clear(){

    }

}
