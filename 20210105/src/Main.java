public class Main {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {1,2,3};
        test(a,0);
        System.out.println(count);
    }
    public static void test(int[] a,int b){
        if(b>=a.length){
            count++;
            System.out.println(java.util.Arrays.toString(a));
        }
        for (int i = b; i < a.length; i++) {
            {int k = a[b];a[b] = a[i];a[i] = k;}//两个数字，进行交换
            test(a,b+1);//用递归进行下一个数的交换
            {int k = a[b];a[b] = a[i];a[i] = k;}//再次交换两个数字，换回来
        }
    }
}