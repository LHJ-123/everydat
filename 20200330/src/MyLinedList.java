class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinedList {
    public Node head;

    public MyLinedList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
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
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
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
        int count = 0;
        Node node = new Node(data);
        Node prev = this.head;
        while (count < index - 1) {
            prev = prev.next;
            count++;
        }
        node.next = prev.next;
        prev.next = node;
    }

    //获取链表长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //判断关键字key是否存在
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

    //打印
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();

    }

    //反转打印
    public void reverseDisplay(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();

    }

    //找节点
    public Node findPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = this.head;
        // Node prev = findPrev(key);
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
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //反转单链表
    public Node reverseList1() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    //头插法反转单链表
    public Node reverseList2() {
        //Node x = head.next;
        int num = this.head.data;
        Node cur = this.head.next;
        while (cur != null) {
            addFirst(cur.data);
            cur = cur.next;
        }
        Node s = this.head;
        while (s != null) {
            if (s.data == num) {
                s.next = null;
                return head;
            }
            s = s.next;
        }
        //  x = null;
       /*     Node u = this.head;
        while(u.next != null) {
            u = u.next;
        }
        u.next = null;*/
        return head;
    }

    //返回链表的中间节点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //返回倒数第K个节点
    public Node FindKthToTail(int k) {
        if (k <= 0 || k > size()) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        int i = 0;
        while (i < k - 1) {
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
    public Node partition(int x) {
        Node cur = this.head;
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    be = cur;
                    bs = be;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (cur.data >= x) {
                    if (as == null) {
                        ae = cur;
                        as = ae;
                    } else {
                        ae.next = cur;
                        ae = ae.next;
                    }
                }

            }
            cur = cur.next;

        }

        if (bs == null) {
            return as;
        } else {
            be.next = as;
            if (as != null) {
                ae.next = null;
            }
            return bs;
        }
    }

    //删除已排序好的链表中重复的结点且该结点不保留
    public Node deleteDuplication() {
        Node node = new Node(-1);
        Node tmp = node;
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;

            }
        }
        tmp.next = null;
        return node.next;
    }

    //判断是否为回文结构
    public boolean chkPalindrome() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;

        while(cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(slow != this.head) {
            if(slow.data != this.head.data) {
                return false;
            }

            if(this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //判断单链表中是否有环
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != null || fast.next != null) {
            return null;
        }
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return  fast;
}

}