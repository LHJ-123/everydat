package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
@Override
    public void work(BookList bookList) {
    System.out.println("删除书籍");
    System.out.println("请输入要删除的图书");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    int pos = 0;
    int i = 0;
    for(i = 0;i<bookList.getUsedSize();i++) {
        Book book = bookList.getBook(i);

        if(book.getName().equals(name)) {
             pos = i;
            break;
        }
    }
    if(i == bookList.getUsedSize()) {
        System.out.println("没有这个书籍");
    }
    for(int j = pos;j<bookList.getUsedSize()-1;j++) {
        Book book = bookList.getBook(j+1);
        bookList.setBook(j,book);
    }
    int curSize = bookList.getUsedSize();
    bookList.setUsedSize(curSize-1);
    System.out.println("删除成功");

    }
}
