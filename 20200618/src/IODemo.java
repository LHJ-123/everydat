import java.io.File;
import java.io.IOException;

public class IODemo {
    //
    private static void listAllFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1:files) {
                listAllFiles(file1);
            }
        }else {
            System.out.println(file);
        }
    }
    public static void main(String[] args) throws IOException {
        //当前文件是否存在是不确定的，需要exists来确认
        File file = new File("d:/zuo.plg");
        System.out.println(file.exists());
        //是否是普通文件
        System.out.println(file.isFile());
        //是否是目录
        System.out.println(file.isDirectory());
        /*file.delete();
        System.out.println(file.exists());*/
        //在磁盘满了的时候会出异常
        file.createNewFile();
        File file1 = new File("d:/test_dir");
        file.mkdir();
        File file2 = new File("d:/test_dir");
        File[] files = file2.listFiles();
        for(File file3:files) {
            System.out.println(file3);
        }

    }
}
