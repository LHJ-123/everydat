import java.io.*;

public class Demo {
    public static boolean addFile(String filePath,String data) {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止

            while (bufferedReader.readLine() != null) {
                line = line+bufferedReader.readLine()+"\\n";
                System.out.println(line);
            }
            line = line+data;
            System.out.println(line);
            bufferedWriter.write(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static void change(String filePath,String oldStr,String newStr){
        try {
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
            String line;
            while (null!=(line=raf.readLine())) {
                if(line.contains(oldStr)){
                    String[] split = line.split(oldStr);
                    raf.seek(split[0].length());
                    raf.writeBytes(newStr);
                    raf.writeBytes(split[1]);
                }
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void delete(String filePath,String oldStr){
        try {
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
            String line;
            while (null!=(line=raf.readLine())) {
                if(line.contains(oldStr)){
                    raf.writeBytes(null);
                }
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void find(String filePath,String oldStr){
        try {
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
            String line;
            while (null!=(line=raf.readLine())) {
                if(line.contains(oldStr)){
                    System.out.println(line);
                    break;
                }
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //find("F:\\小学信息管理.txt","小林");
        boolean ret = addFile("F:\\小学信息管理.txt","小明 男 11 3班");
        System.out.println(ret);
    }
}
