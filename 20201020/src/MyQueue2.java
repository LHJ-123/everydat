public class MyQueue2 {
    public int[] array = new int[100];
    public int head;
    public int tail;
    public int size;
    public boolean offer(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail++;
        if (tail>=array.length) {
            tail = 0;
        }
        size++;
        return true;
    }


    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[head];
        head++;
        if (head>=array.length) {
            head = 0;
        }
        size--;
        return ret;
    }
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }
}
