import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<10;i++) {
            str.append("assa"); //修改了当前字符串，把新内容加在后面
        }
        System.out.println(str);
    }
    public static void main6(String[] args) {
        String str = "";
        for(int i = 0;i<1000;i++) {
            str+="aas";    //也是新建了字符串，原来字符串并没有改变
//效率比较低
        }
        System.out.println(str);

    }
    public static void main5(String[] args) {
        String str = "Hello";
        //未修改原来字符串，新建了字符串
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }
    public static void main4(String[] args) {
        String str = "\n \t   saad  \n";
        //trim  消除空白字符：空格，制表符，回车，换行
        //原来字符串不会改变，新建了字符串
        String str1 = str.trim();
        System.out.println(str);
        System.out.println("==========");
        System.out.println(str1);
    }
    public static void main3(String[] args) {
        String str = "hello world";
        //前闭后开
        System.out.println(str.substring(6,9));
    }
    public static void main2(String[] args) {
        String str1 = "aa,sss,sss";
        String str2 = "aa,,sss,sss";
        //根据逗号进行分割
        String str = "132.232.1.1";
        //正则表达式"."有特殊含义，需要转移，正则中转义一次，Java中转义一次

        String[] ret1 = str.split("\\.");
        String[] ret = str2.split(",");
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(ret1));
    }
    public static void main1(String[] args) {
        String str1 = "hello world";
        String str2 = "wor";
        String str3 = "worsdwor";
        //str1是否包含str2  contains
        System.out.println(str1.contains(str2));
        //str2再str1中所在的下标位置
        System.out.println(str1.indexOf(str2));
        //有多个，以最左边的下标返回
        System.out.println(str3.indexOf(str2));
        //从最右边开始计数
        System.out.println(str3.lastIndexOf(str2));
        //startWith  endWith判断是否以什么什么为开头或者结尾
        System.out.println(str1.startsWith("hello"));
        System.out.println(str1.endsWith("hello"));
        System.out.println(str1.endsWith("world"));
        //替换  不修改原来的值，新建了一个字符串
        String ret = str1.replaceAll("world","java");
        System.out.println(str1);
        System.out.println(ret);


    }
}
