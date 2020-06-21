import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo3 {
    public static void main(String[] args) {
        //testNoBuffer();
        testBuffer();
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/1024.jpg"))) {
            int ch = -1;
            while ((ch = bufferedInputStream.read())!=-1) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(" buffer:"+(end-beg)+"ms");


    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("d:/1024.jpg")) {
            int ch = -1;
            while ((ch = fileInputStream.read())!=-1) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer:"+(end-beg)+"ms");

    }

}
