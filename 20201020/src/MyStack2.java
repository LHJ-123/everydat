public class MyStack2 {
    public int[] array = new int[100];
    public int size = 0;

    public void push(int value) {
        array[size] = value;
        size++;

    }

    public Integer pop() {
        if (size<0) {
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }
    public Integer peek() {
        if (size<=0) {
            return null;
        }
        int ret = array[size-1];
        return ret;
    }
}
