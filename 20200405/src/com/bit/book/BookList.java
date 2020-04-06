package com.bit.book;

public class BookList {
    private Book[] books=new Book[10];
    private int usedSize;

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public BookList() {
        this.books = new Book[10];

        this.books[0] = new Book("西游戏","吴承恩",12,"小说");
        this.books[1] = new Book("三国演义","施耐庵",14,"小说");
        this.books[2] = new Book("水浒传","罗贯中",16,"小说");
        this.usedSize = 3;
    }

    public Book getBook(int i) {
        return books[i];
    }
    public void setBook(int i,Book book) {
        books[i] = book;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
