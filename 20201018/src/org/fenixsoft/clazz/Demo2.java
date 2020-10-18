package org.fenixsoft.clazz;
public class Demo2 {
    private static int m;

    public static int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        m = 2;
        System.out.println(inc());
    }

}
