package com.bit.user;

import com.bit.book.BookList;
import com.bit.operation.AddOperation;
import com.bit.operation.FindOperation;
import com.bit.operation.IOperation;

abstract public class User {
    public String name;
    public IOperation[] Operations;

    public User(String name) {
        this.name = name;

    }

    public abstract int menu();
    public void doOperation(int choice, BookList bookList) {
        Operations[choice].work(bookList);
    }
}
