import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
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
    public static void main(String[] args) throws IOException {

        copyFile("e:/1/123.jpg","e:/1/1234.jpg");
    }
}
