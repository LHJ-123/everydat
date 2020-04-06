package com.bit.user;

import com.bit.operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.Operations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),


        };
    }

    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello"+this.name+"欢迎来到java16的图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("请输入你要进行的操作:");
        int choice = scanner.nextInt();
        return choice;
    }


}
