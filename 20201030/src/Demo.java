class Book {
    private int ISBN;
    private String press;
    private String author;
    private int price;
    private int page;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) throws BookSetException {
        if (ISBN<=0) {
            throw new BookSetException("该书籍编号格式有误");
        } else {
            this.ISBN = ISBN;
        }
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
       this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws BookSetException {
        if (price<=0 || price >400) {
            throw new BookSetException("价格不合法");
        } else {
            this.price = price;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) throws BookSetException {
        if (page<=0 || page >1000) {
            throw new BookSetException("该书页数不合法");
        } else {
            this.page = page;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", page=" + page +
                '}';
    }
}
public class Demo {
    public static void main(String[] args) throws BookSetException {
        Book book = new Book();
        book.setISBN(2333);
        book.setPress("新华出版社");
        book.setAuthor("黑客");
        book.setPrice(55);
        book.setPage(555);
        System.out.println(book);
    }
}
