import java.io.*;
import java.util.*;

public class Modify {
    public Library[] findName(String name){
        ArrayList<Library> ret = new ArrayList<Library>();

        try{
            FileReader fr = new FileReader("F:\\Java\\Library.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                if (infos[0].equals(name)){
                    ret.add(new Library(infos[0], infos[1], infos[2], infos[3]));
                }

                temp = br.readLine();
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return (Library[])ret.toArray(new Library[ret.size()]);
    }

    public Library findNum(String num){
        Library ret = null;

        try{
            FileReader fr = new FileReader("F:\\1.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                if (infos[1].equals(num)){
                    ret = new Library(infos[0], infos[1], infos[2], infos[3]);
                    break;
                }

                temp = br.readLine();
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return ret;
    }

    public Library[] findNameAt(String name){
        ArrayList<Library> ret = new ArrayList<Library>();
        try{
            FileReader fr = new FileReader("F:\\Java\\Library.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                if (infos[0].contains(name)){
                    ret.add(new Library(infos[0], infos[1], infos[2], infos[3]));
                }

                temp = br.readLine();
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return (Library[])ret.toArray(new Library[ret.size()]);
    }

    public Library[] findAllLibrary(){
        ArrayList<Library> ret = new ArrayList<Library>();

        try{
            FileReader fr = new FileReader("F:\\Java\\Library.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                ret.add(new Library(infos[0], infos[1], infos[2], infos[3]));
                temp = br.readLine();
            }

            br.close();
            fr.close();

        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return (Library[])ret.toArray(new Library[ret.size()]);
    }

    private ArrayList<Library> findAllLib(){
        ArrayList<Library> ret = new ArrayList<Library>();

        try{
            FileReader fr = new FileReader("F:\\Java\\Library.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                ret.add(new Library(infos[0], infos[1], infos[2], infos[3]));
                temp = br.readLine();
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return ret;
    }

    private boolean checkNumIsExist(String num){
        boolean ret = false;

        try{
            FileReader fr = new FileReader("F:\\Java\\Library.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            while (temp != null){
                String[] infos = temp.split(" ");

                if (infos[1].equals(num)){
                    ret = true;
                    break;
                }

                temp = br.readLine();
            }

            br.close();
            fr.close();
        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }

        return ret;
    }

    public void addLibrary(Library lib){
        if (!checkNumIsExist(lib._num)){
            try{
                FileWriter fw = new FileWriter("F:\\1.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                StringBuffer str = new StringBuffer();

                str.append(lib._name + " ");
                str.append(lib._num + " ");
                str.append(lib._isUsed + " ");
                str.append(lib._capacity + " ");
                bw.newLine();

                bw.write(str.toString());
                bw.close();
                fw.close();

                System.out.println("添加成功!");
            }catch (FileNotFoundException ex){

            }catch (IOException ex){

            }
        }
    }

    public void delLibrary(String num){
        if (checkNumIsExist(num)){
            ArrayList<Library> libs = findAllLib();

            for (int i = 0; i < libs.size(); i++){
                Library temp = (Library)libs.get(i);
                if (temp._num.equals(num)){
                    libs.remove(num);
                    break;
                }
            }
            try{
                FileWriter fw = new FileWriter("F:\\Java\\Library.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < libs.size(); i++){
                    Library temp = (Library)libs.get(i);
                    StringBuffer str = new StringBuffer();

                    str.append(temp._name + " ");
                    str.append(temp._num + " ");
                    str.append(temp._isUsed + " ");
                    str.append(temp._capacity + " ");

                    bw.write(str.toString());
                    bw.newLine();
                }

                bw.close();
                fw.close();

                System.out.println("删除成功！");
            }catch (FileNotFoundException ex){

            }catch (IOException ex){

            }
        }
    }

    public void updateLibrary(Library lib){
        delLibrary(lib._num);
        addLibrary(lib);

        System.out.println("修改成功！");
    }

    public void PrintOne(Library lib){
        lib.PrintOne();
    }

    public void Print(Library[] libs){
        for (int i = 0; i < libs.length; i++){
            libs[i].PrintOne();
        }
    }
}
