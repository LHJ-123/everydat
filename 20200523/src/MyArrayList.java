import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_SIZE = 10;
    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void add(int pos,int data) {
        if (isFull()) {
            System.out.println("数组满了");
            return;
        }
        if (pos<0 || pos>this.usedSize) {
            System.out.println("位置不合法");
            return;
        }
        int i = pos;
        for (i = pos;i<this.usedSize;i++) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    public void display() {
        for (int i = 0;i<this.usedSize;i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    public boolean contains(int toFind) {
        if (isEmpty()) {
            System.out.println("数组为空");
            return false;
        }
        for(int i = 0;i<this.usedSize;i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }
    public int search(int toFind) {
        if (isEmpty()) {
            System.out.println("数组为空");
            return -1;
        }
        for (int i = 0;i<this.usedSize;i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos) {
        if (isEmpty()) {
            System.out.println("数组为空");
            return -1;
        }
        if (pos<0||pos>this.usedSize) {
            System.out.println("位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    public int size() {
        return this.usedSize;
    }
    public void remove(int toRemove) {
        if (isEmpty()) {
            System.out.println("数组为空");
            return;
        }
        if (search(toRemove) == -1) {
            return;
        }
        int index = search(toRemove);
        for (int i = index;i<this.usedSize;i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    public void clear() {
        this.usedSize = 0;
    }
    public void grow() {
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }
}
