
/*
package NowCoder;
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
     Test test = new Test();
     test.hello();
    }
}*/

/*

class Book {
    private String name;
    private String author;
    private int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名='" + name + '\'' +
                ", 作者='" + author + '\'' +
                ", 价格=" + price +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Book book = new Book("三国演义", "罗贯中", 23);
        System.out.println(book);
    }
}*/

/*

class Swap {

   */
/* private int a;
    private int b;

    public Swap(int a, int b) {
        this.a = a;
        this.b = b;
    }*//*

    public void show(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a);
        System.out.println(b);
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Swap x = new Swap();
        int a = 12;
        int b = 23;
        x.show(a,b);
    }
}*/
/*public class TestDemo {
    public boolean contains(int toFind) {
      if(this.elem == null) {
          System.out.println("数组为空");
      }
      for(int i = 0;i<this.elem.length;i++) {
          if(this.elem[i] == data) {
              return true;
          }else {
              return false;
          }
      }
    }

    public int search(int toFind) {
        if(this.elem == null) {
            System.out.println("数组为空");
        }
        for(int i = 0;i<this.elem.length;i++) {
            if(this.elem[i] == data) {
                return i;
            }else {
                System.out.println("不存在");;
            }
        }
    }


    public int getPos(int pos) {
        if(this.elem == null) {
            System.out.println("数组为空");
        }else {
            return this.elem[pos];
        }

public void remove(int key) {
            while (this.search(key) != -1 ) {
                for(int i = index;i<this.usedSize-1;i++) {
                    this.elem[i] = this.elem[i+1];
                }
                this.uesdSize--;


            }
            }
        }



    public static void main(String[] args) {

    }
}*/

/*

public class TestDemo{
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args){
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };
}*/

/*
class Test{

    public String toString() {

        System.out.print("aaa");

        return "bbb";

    }

}

public class TestDemo {


    public static void main(String[] args) {

        System.out.println(new Test());
    }
}
*/




import java.util.Arrays;

public class TestDemo {
    public static void swap(int[] array1,int[] array2) {
      int[] array3 = new int[array2.length];
      for(int i = 0;i<array2.length;i++) {
          array3[i] = array2[i];
          array2[i] = array1[i];
          array1[i] = array3[i];
      }

    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {2,3,4,5,3,2};
        swap(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
