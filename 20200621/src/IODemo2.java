import java.io.*;

public class IODemo2 {
    public static void main(String[] args) {
        copyFile2();

    }
    private static void copyFile() throws IOException {
        //先得创建FileInputStream和FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("e:/1/123.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("e:/1/1234.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer,0,len);
        }
        //此处设计四个流对象
        //调用这组close，就会自动把内部包含的FileInputStream，FileOutputStream关闭
        //也没有先后关闭顺序
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    private static void copyFile2() {
     try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("e:/1/123.jpg"));
     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("e:/1/1234.jpg"))) {
         int len = -1;
         byte[] buffer = new byte[1024];
         while ((len = bufferedInputStream.read(buffer))!=-1) {
             bufferedOutputStream.write(buffer,0,len);
             System.out.println(len);
         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
    }
}
