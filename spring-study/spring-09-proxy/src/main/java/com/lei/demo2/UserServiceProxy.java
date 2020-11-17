package com.lei.demo2;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.delete();
    }

    public void update() {
        log("update");
       userService.update();
    }

    public void find() {
        log("find");
       userService.find();
    }
    public void log(String msg) {
        System.out.println("使用了"+msg+"方法");
    }
}
