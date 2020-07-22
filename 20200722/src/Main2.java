

//day44 2
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //正则表达式，a-z是所有bai小写字母 A-Z是所有大写字母
        // [a-zA-Z]+ 这个就是一个不分大du小zhi写字母dao的英文单词（无限字母） 最少是一个字母
        //前面加个^就是除了这些字母外的其他字符
        String[] sp = sc.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        //trim()表示删除这个字符串的前面和后面的尾随空格
        System.out.println(sb.toString().trim());

    }

}

