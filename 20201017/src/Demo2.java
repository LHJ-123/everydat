import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        char[][] c= new char[3][3];
        for (int i = 0;i<c.length;i++) {
            for (int j = 0;j<c[0].length;j++) {
                c[i][j] = '*';
            }
        }
        /*for (int i = 0;i<c.length;i++) {
            System.out.println(Arrays.toString(c[i]));
        }*/
        for (int i = 0;i<c.length;i++) {
            for (int j = 0;j<c[0].length;j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }
}
