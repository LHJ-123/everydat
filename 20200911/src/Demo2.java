public class Demo2 {
    public static int x;
    public static int y;
    public static void FindLocation(int[] array,int key) {
        int i = 0;
        int j = array.length-1;
        int sum = 0;
        while (i<j) {
            sum = array[i]+array[j];
            if(sum>key) {
                j--;
            }else if (sum<key) {
                i++;
            }else {
                x = i;
                y = j;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7,7,8};
        int key = 8;
        FindLocation(array,key);
        System.out.println(x+" "+y);
    }
}
