package com.bit.operation;

import com.bit.book.BookList;

public class ExitOperation implements IOperation{
@Override
    public void work(BookList bookList) {
    System.out.println("退出系统");
    System.exit(0);
    }
}
