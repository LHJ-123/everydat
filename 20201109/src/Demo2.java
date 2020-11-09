import java.io.*;

public class Demo2 {
    private static void copyFile(String a,String b ) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(a);
        FileOutputStream fileOutputStream = new FileOutputStream(b);
       byte[] buffer = new byte[1024];
       int len = fileInputStream.read(buffer);
       while (len != -1) {
           fileOutputStream.write(buffer,0,len);
           len = fileInputStream.read(buffer);
       }
       fileInputStream.close();
       fileOutputStream.close();
    }


    private static void copyFile2()  {
        //try语句会在代码执行完毕后自动调用close方法，前提是这个类必须实现Closable接口
        try( FileInputStream fileInputStream = new FileInputStream("F:\\a\\我.png");
             FileOutputStream fileOutputStream = new FileOutputStream("F:\\b\\我1.png")) {
            byte[] buffer  = new byte[1024];
            int len = -1;
            while (( len = fileInputStream.read(buffer) ) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void copyFile3()  {
        //try语句会在代码执行完毕后自动调用close方法，前提是这个类必须实现Closable接口
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("F:\\a\\我.png"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\b\\我1.png"))) {
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len=bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void copyFile4() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/890.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/8901.txt"))) {
        String line = "";
        //按行读取
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        //copyFile("F:\\a\\我.png","F:\\b\\我1.png");
          copyFile2();
    }
}
