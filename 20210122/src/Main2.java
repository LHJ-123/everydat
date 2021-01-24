public class Main2 {
    //调整数组顺序是奇数位于偶数前面
    public void reOrderArray(int [] array) {
        int[] arr = new int[array.length];
        int[] arr2 = new int[array.length];
        int index = 0;
        int index2 = 0;
        for (int i = 0;i<array.length;i++) {
            if (array[i]%2 == 0) {
                arr2[index2] = array[i];
                index2++;
            }else {
                arr[index] = array[i];
                index++;
            }
        }
        int cur = 0;
        for (int i = index;i<array.length;i++) {
            arr[i] = arr2[cur];
            cur++;
        }
        for (int i = 0;i<array.length;i++) {
            array[i] = arr[i];
        }
    }
    public void reOrderArray2(int [] array){
        if (array.length <= 1) {
            return;
        }
        int i = 0;
        while (i<array.length) {
            int j = i+1;
            if (array[i]%2 == 0) {
                while (array[j]%2 == 0) {
                    if (j == array.length-1) {
                        return;
                    }
                    j++;
                }
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while (count>1) {
                    array[i+count] = array[i+count-1];
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }

    }
}
