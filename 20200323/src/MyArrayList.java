import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_SIZE = 10;
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    //判断数组是否满了
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    //插入一个元素
    public void add(int pos,int data) {
        if(isFull()) {
            System.out.println("数组满了");
            return;
        }
        if(pos<0 || pos>this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        int i = pos;
        for(i =pos;i<this.usedSize;i++) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //打印
    public void display() {
        for(int i = 0;i<this.usedSize;i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()) {
            System.out.println("数组为空");
            return false;
        }
        for(int i = 0;i<this.usedSize;i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    //判断数组是否为空
    public boolean isEmpty() {
        if(this.usedSize == 0) {
            return true;
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()) {
            System.out.println("数组为空");
            return -1;
        }
        for(int i = 0;i<this.usedSize;i++) {
            if(this.elem[i] == toFind) {
                return i;
            }

        }
        return -1;
    }
    //获取pos位置元素
    public int getPos(int pos) {
        if(isEmpty()) {
            System.out.println("数组为空");
            return -1;
        }
        if(pos<0 || pos>this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];

    }
    //获取顺序表长度
    public int size() {
        return  this.usedSize;
    }
    //删除第一次出现的关键字
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("数组为空");
            return ;
        }
        if(search(toRemove)==-1) {
            return;
        }
        int index = search(toRemove);
        for(int i = index;i<this.usedSize;i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
    //扩容
    public void grow() {
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }



}

