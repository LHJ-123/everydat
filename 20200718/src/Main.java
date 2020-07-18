import java.util.Arrays;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer x:arr) {
            Integer count =map.get(x);
            if(count == null) {
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        for(int i = 0;i<n;i++) {
            Integer s = map.get(arr[i]);
            if(s%2 != 0) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
