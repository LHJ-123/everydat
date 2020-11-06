import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo3 {
    public static void main(String[] args) {
        String s = "D";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        s = s+dateFormat.format(date.getTime())+System.getProperty("user.name");
        System.out.println(s);
    }
}
