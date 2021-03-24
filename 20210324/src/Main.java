public class Main {
    public int[] reOrderArray (int[] array) {
        // write code here
        if (array.length <= 1) {
            return array;
        }
        int i = 0;
       while (i<array.length) {
           int j = i+1;
           if (array[i]%2 == 0) {
               while (array[j]%2 == 0) {
                   if (j == array.length-1) {
                       return array;
                   }
                   j++;
               }
               int count = j-i;
               int tmp = array[i];
               array[i] = array[j];
               while (count>1) {
                   array[i+count] =array[i+count-1];
                   count--;
               }
               array[i+1] = tmp;
           }
           i++;
       }
       return array;
    }
}
