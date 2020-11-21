import java.io.*;

public class Demo {
    private static void find(String name) {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/1.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:/2.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(name)) {
                    bufferedWriter.write(line);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void add(String name,int age,String sex,String grade) {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/1.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:/3.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line+"\n");
            }
            String user = name+" "+age+" "+sex+" "+grade;
            bufferedWriter.write(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void delete(String name) {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/1.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:/4.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ((line = bufferedReader.readLine()) != null) {
               if (line.startsWith(name)) {
                   bufferedWriter.write("");
               }else {
                   bufferedWriter.write(line+"\n");
               }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void update(String name,String newGrade) {
        //带缓存区的字符流有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("F:/1.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:/5.txt"))) {
            String line = "";
            //readLine表示读取一行，读到换行符为止
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(name)) {
                    String[] info = line.split(" ");
                    String newInfo = info[0]+" "+info[1]+" "+info[2]+" "+newGrade;
                    bufferedWriter.write(newInfo+"\n");
                }else {
                    bufferedWriter.write(line+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //find("小智");
        //add("小兰",10,"女","3班");
        //delete("小资");
        update("小明","1班");


    }

}
