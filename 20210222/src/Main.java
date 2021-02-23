public class Main {
    public void reOrderArray(int [] array) {
        if (array == null||array.length <= 1) {
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
                int tmp = array[i];
                array[i] = array[j];
                while (count>1) {
                    array[i+count] = array[i+count-1];
                    count--;
                }
                array[i+1] = tmp;
            }
            i++;
        }

    }
}
