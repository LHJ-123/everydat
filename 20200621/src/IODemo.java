import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    private static void copyFile(String srcPath ,String destPath) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();


    }
    private static void copyFile2(String srcPath ,String destPath)  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
           fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }

                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private static void copyFile3()  {
        //try语句会在代码执行完毕后自动调用close方法，前提是这个类必须实现Closable接口
    try(FileInputStream fileInputStream = new FileInputStream("e:/1/123.jpg");
    FileOutputStream fileOutputStream = new FileOutputStream("e:/1/1234.jpg")) {
       byte[] buffer = new byte[1024];
       int len = -1;
       while ((len = fileInputStream.read(buffer)) != -1) {
           fileOutputStream.write(buffer,0,len);
       }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    }



    public static void main(String[] args) throws IOException {

        copyFile("e:/1/123.jpg","e:/1/1234.jpg");
    }
}
