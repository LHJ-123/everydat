import java.lang.reflect.Field;

/*public class TestDemo {
    public static void main(String[] args) {
        try {
            int[] array = null;
            System.out.println(array.length);
        }catch (NullPointerException e) {
            System.out.println("捕获了异常!");
        }
        System.out.println("=============");
    }
}*/
/*
public class TestDemo {

    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main(String[] args) {

        ((TestDemo)null).testMethod();

    }

}*/
public class TestDemo {
    public static int compareTo(String str1,String str2) {
        int count = 0;
        if(str1.length()<=str2.length()) {
             count = str1.length();
        }else {
            count = str2.length();
        }
        for(int i = 0;i<count;i++) {
            if(str1.charAt(i)<str2.charAt(i)) {
                return -2;
            }
            if(str1.charAt(i)>str2.charAt(i)) {
                return 1;
            }
            if(str1.charAt(i)==str2.charAt(i)) {
                continue;
            }
        }
        if(str1.length()==str2.length()) {
            return 0;
        }
        if(str1.length()>str2.length()) {
            return 1;
        }
        if(str1.length()<str2.length()) {
            return -2;
        }
        return -1;
    }
    public static void main(String[] args) {
        String str1 = "aaaaa";
        String str2 = "aaaaa";
        int ret = compareTo(str1,str2);
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        char[] array = {'h','e','h','e'};
        String str = new String(array);
        System.out.println(str);
        for(int i = 0;i<str.length();i++) {
            System.out.println(str.charAt(i));
        }
    }
    public static void main2(String[] args) throws NoSuchFieldException, IllegalAccessException {
//反射
        String str = "hehe";
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[])field.get(str);
        value[0] = 'a';
        System.out.println(str);
    }
    public static void main1(String[] args) {


        String str1 = "hehe";//更推荐这种

        String str2 = new String("hehe").intern();//又拷贝了一份
        //intern() 查询池中String是否存在，不存在吧String加入池中，若存在则直接获取池中对应对象的引用。


        char[] buffer = {'a','b','c'};
        String str3 = new String(buffer);

       int a = 10;
       int b = 10;
        System.out.println("hehe".equals(str1));//更推荐这种写法
        System.out.println(str1.equals("hehe"));//可能会发生空指针异常
        System.out.println(str1 == str2);

    }
}


