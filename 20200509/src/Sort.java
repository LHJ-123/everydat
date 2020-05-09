import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//标准库中的排序
public class Sort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(6);
        Collections.sort(arrayList);//对集合类进行排序
        System.out.println(arrayList);

        int[] array = {9,5,2,7,3,6,8};
        Arrays.sort(array);//对数组进行排序
        System.out.println(Arrays.toString(array));
    }
}
