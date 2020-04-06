package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
@Override
    public void work(BookList bookList) {
    System.out.println("查找书籍");
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入要查找的图书");
    String name = scanner.nextLine();
    for(int i = 0;i<bookList.getUsedSize();i++) {
        Book book = bookList.getBook(i);

        if(book.getName().equals(name)) {
            System.out.println(bookList.getBook(i));
            System.out.println("查找到了这本书");
            return;
        }
    }
    System.out.println("没找到这本书");
    }
}
