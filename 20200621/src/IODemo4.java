import java.io.*;

public class IODemo4 {
    public static void main(String[] args) {
        copyFile3();

    }
    private static void copyFile() {
        //处理文本文件
        try(FileReader fileReader = new FileReader("d:/890.txt");
            FileWriter fileWriter = new FileWriter("d:/8901.txt")) {
           char[] buffer = new char[1024];
           int len = -1;
           while ((len = fileReader.read(buffer))!=-1) {
               fileWriter.write(buffer,0,len);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile2() {
        //处理文本文件
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/890.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/8901.txt"))) {
         char[] buffer = new char[1024];
         int len = -1;
         while ((len = bufferedReader.read(buffer))!=-1) {
             bufferedWriter.write(buffer,0,len);
         }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFile3() {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/890.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/8901.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("line:"+line);
                bufferedWriter.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
