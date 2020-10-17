class Bag {
    Book book;
    Pen pen;
    Computer computer;

    public Bag(Book book, Pen pen, Computer computer) {
        this.book = book;
        this.pen = pen;
        this.computer = computer;
    }
    public void inform() {
        System.out.println("背包里有:");
        System.out.println(this.book);
        System.out.println("======");
        System.out.println(this.pen);
        System.out.println("======");
        System.out.println(this.computer);
    }
    public void sumPrice() {
        System.out.println("背包总价值:");
        System.out.println(this.book.price+this.pen.price+this.computer.price+"元");
    }
}
class Book {
    String name;
    int price;
    String type;
    String author;

    public Book(String name, int price, String type, String author) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "名字='" + name + '\'' +
                ", 价格=" + price +"元"+
                ", 类型='" + type + '\'' +
                ", 作者='" + author + '\'' +
                '}';
    }
}
class Pen {
    String type;
    int price;

    public Pen(String type, int price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "类型='" + type + '\'' +
                ", 价格=" + price +"元"+
                '}';
    }
}
class Computer {
    String name;
    String type;
    int price;
    int time;

    public Computer(String name, String type, int price, int time) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "名字='" + name + '\'' +
                ", 类型='" + type + '\'' +
                ", 价格=" + price +"元"+
                ", 待机时间=" + time +"小时"+
                '}';
    }
}
public class Demo8 {
    public static void main(String[] args) {
        Book book = new Book("Java入门",50,"计算机类","黑马程序员");
        Pen pen = new Pen("圆珠笔",5);
        Computer computer = new Computer("戴尔","商务本",6000,3);
        Bag bag = new Bag(book,pen,computer);
        bag.inform();
        bag.sumPrice();
    }

}
