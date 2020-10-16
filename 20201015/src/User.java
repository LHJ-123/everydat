abstract public class User {
    public String name;
    public IOperation[] Operations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void doOperation(int choice,BookList bookList) {
        Operations[choice].work(bookList);
    }
}
