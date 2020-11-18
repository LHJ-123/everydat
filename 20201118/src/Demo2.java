import java.io.*;

public class Demo2 {
    private static void copyFile3() {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\小学信息管理.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:\\小学信息管理1.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ( bufferedReader.readLine() != null) {
                line = line+bufferedReader.readLine()+"\\n";
            }
            bufferedWriter.write(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFile3();
    }
}
