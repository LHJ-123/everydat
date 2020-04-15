public class MyStack {
    //栈可基于顺序表实现，也可基于链表实现

    //基于顺序表
    private int[] array = new int[100];
    private int size = 0;
//入栈
    public void push(int value) {
        array[size] = value;
        size++;


    }
//出栈
    public Integer pop() {
        if(size <= 0) {
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }
  //取栈顶元素
    public Integer peek() {
        if(size <= 0) {
            return null;
        }
        int ret = array[size-1];
        return ret;

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        Integer cur = null;
        while ((cur = myStack.pop()) != null) {
            System.out.println(cur);
        }


    }
}
