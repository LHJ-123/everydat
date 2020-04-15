public class MyQueue2 {
    //基于顺序表实现
    public int[] array = new int[100];
    public int head = 0;
    public int tail = 0;
    public int size = 0;
    //入队列
    public boolean offer(int value) {
    if (size == array.length) {
        return false;
    }
    array[tail] = value;
    tail++;
    if (tail >= array.length) {
        tail = 0;
    }
    size++;
    return true;

    }
    //出队列（链表头删）
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;

    }
    //取队首
    public Integer peek() {
      if (size == 0) {
          return null;
      }
      return array[head];

    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        Integer cur = null;
        while ((cur = myQueue2.poll()) != null) {
            System.out.println(cur);
        }
    }

}
