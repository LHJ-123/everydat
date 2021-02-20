public class Main8 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null||array.length == 0) {
            return 0;
        }
        int first = 0;
        int last = array.length-1;
        while (first<last) {
            if (array[last]>array[first]) {
                return array[first];
            }
            int mid = (last+first)/2;
            if (array[mid]>array[last])  {
                first = mid+1;
            }else if (array[mid]<array[last]) {
                last = mid;
            }else {
                last--;
            }
        }
        return array[first];
    }
}
