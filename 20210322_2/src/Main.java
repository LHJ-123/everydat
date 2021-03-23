public class Main {
    public int minNumberInRotateArray(int [] array) {
        if (array == null||array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        while (left<right) {
            if (array[right] > array[left]) {
                return array[left];
            }
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
