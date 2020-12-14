package com.lei.controller;


import com.lei.pojo.Books;
import com.lei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
       //controller调用service层
    @Autowired
    @Qualifier(value = "bookServiceImpl")
private BookService bookService;

    //查询全部书籍，并返回书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    //书籍增加页面
    @RequestMapping("/toAddBook")
    public String toAddPage() {
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";

    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("qBooks",books);
        return "updateBook";

    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        int i = bookService.updateBook(books);
        if (i>0) {
            System.out.println("添加成功");
        }
        List<Books> books1 = bookService.queryAllBook();
        for (Books books2:books1) {
            System.out.println(books2);
        }
        return "redirect:/book/allBook";

    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";

    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model) {
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null) {
          list = bookService.queryAllBook();
          model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";

    }


}
