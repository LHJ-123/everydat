import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>>  lists =new ArrayList<>();
        String result = "";
        while (scanner.hasNext()) {
            ArrayList<String> list = new ArrayList<>();
            String s = scanner.next();
            String[] arr = s.split(":");
            if ("query".equals(arr[0])) {
                result = result+s;
                break;
            }
            list.add(arr[1]);
            String[] split = arr[2].split(",");
            for (int i = 0;i<split.length;i++) {
                list.add(split[i]);
            }
            lists.add(list);
        }
        printR(lists,result);
    }

    //dict:停词:我想,的,从,去
    //dict:目的地:北京,广州,深圳
    //dict:节假日:暑假,寒假,春节
    //dict:出发地:西安,东北
    //dict:和谁去:同学,家人
    //dict:目标:学习AC自动机,玩,吃
    //query:我想暑假从西安去北京和同学学习AC自动机

    private static void printR(ArrayList<ArrayList<String>> lists, String result) {
        for (int i = 0;i<lists.size();i++) {
            ArrayList<String> list = lists.get(i);
            for (int j = 0;j<list.size();j++) {
                if (result.contains(list.get(j))) {

                    System.out.println(list.get(j)+":"+"["+list.get(0)+"]");
                    result = result.replace(list.get(j),"");
                }
            }
        }
    }
}
