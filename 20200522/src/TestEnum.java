import java.util.Arrays;

//用于表示穷举的概念,不建议完成其他不该完成的工作

enum Sex {
    MALE,
    FEMALE,
    UNKNOWN;
}
public class TestEnum {
    public static final int Male = 0;
    public static final int Female = 1;
    public static final int UnKnow = 2;

    public static void main(String[] args) {
        /*if (Male+1 == Female) {

        }*///编译可以通过但不合理


        /*if (Sex.MALE+1 == Sex.FEMALE) {

        }*///用枚举编译直接报错
        Sex s = Sex.MALE;
        System.out.println(s);
        System.out.println(Arrays.toString(Sex.values()));
    }
}
