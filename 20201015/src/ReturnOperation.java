import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的图书");
        String name = scanner.next();
        for (int i = 0;i<bookList.getUsedSize();i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(false);
                System.out.println("归还成功");
                return;
            }
        }
        System.out.println("没找到这本书");
    }
}
