package com.onlibrary.controller;

/**
 * Created by harkonnen on 15.03.16.
 */

import com.onlibrary.dao.BooksDao;
import com.onlibrary.entity.Book;
import com.onlibrary.entity.User;
import com.onlibrary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;


@Controller
public class BooksController {

    @Autowired()
    private BooksDao booksDao;

    @Autowired()
    private UsersService usersService;

    @RequestMapping("/")
    public String showBooks(Model model) {

        System.out.println("Home Controller");

        model.addAttribute("booksList", booksDao.getAllBooks());

        return "books";
    }

    @RequestMapping("/addbook")
    public String addBooks(Model model) {

        System.out.println("Home Controller: add");

        Book b = new Book("Book1","I'm", "Sci-Fi", "filename.pdf");

        booksDao.save(b);

        model.addAttribute("booksList", booksDao.getAllBooks());

        return "books";
    }

    @RequestMapping("/test")
    public String test(Model model) {

        System.out.println("Home Controller: test");

        Book b2 = new Book("Book2","I'm", "Sci-Fi", "filename2.pdf");
        Book b3 = new Book("Book3","I'm", "Sci-Fi", "filename3.pdf");
        System.out.println("Home Controller: test saving");
        booksDao.save(b2);
        booksDao.save(b3);
        System.out.println("Home Controller: test User");
        User u = new User("aquariusmaster", "Andrey", "password", "aquariusmaster@yandex.ru", true, "ADMIN");

        Set<Book> favBook = new HashSet<Book>();
        favBook.add(b2);
        favBook.add(b3);
        u.setFavBooks(favBook);

        usersService.create(u);

        System.out.println("Home Controller: test User Saved");

        model.addAttribute("usersList", usersService.getAllUsers());

        return "users";
    }

    @RequestMapping("/users")
    public String showUsers(Model model) {

        System.out.println("Home Controller showUsers");

        model.addAttribute("usersList", usersService.getAllUsers());

        return "users";
    }


    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String showBook(Model model, @PathVariable int bookId) {

        Book book = booksDao.getBookById(bookId);
        model.addAttribute("book", book);

        return "book";
    }


    @RequestMapping(value = "/get/{filename}", method = RequestMethod.GET)
    public String showBook(Model model, @PathVariable String filename) {


        return "book";
    }
}
