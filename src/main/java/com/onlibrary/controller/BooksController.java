package com.onlibrary.controller;

/**
 * Created by harkonnen on 15.03.16.
 */

import com.onlibrary.entity.Book;
import com.onlibrary.exception.BookUploadException;
import com.onlibrary.service.BooksService;
import com.onlibrary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.*;

import org.apache.log4j.Logger;


@Controller
public class BooksController {

    @Autowired()
    private BooksService booksService;

    @Autowired()
    private UsersService usersService;

    private static final Logger DEBUG_LOGGER = Logger.getLogger(BooksController.class);

    @RequestMapping("/")
    public String showBooks(Model model) {

        if( DEBUG_LOGGER.isDebugEnabled()){
            DEBUG_LOGGER.debug("BooksController.showBooks() is executed!");
        }

        model.addAttribute("booksList", booksService.getAllBooks());

        return "books";
    }

    @RequestMapping("/add")
    public String addBooks(Model model) {

        if( DEBUG_LOGGER.isDebugEnabled()){
            DEBUG_LOGGER.debug("BooksController.addBooks() is executed!");
        }

        //booksService.save(b, pdffile);

        model.addAttribute("booksList", booksService.getAllBooks());

        return "books";
    }




    @RequestMapping("/users")
    public String showUsers(Model model) {

        System.out.println("Home Controller showUsers");

        model.addAttribute("usersList", usersService.getAllUsers());

        return "users";
    }


    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String showBook(Model model, @PathVariable int bookId) {

        Book book = booksService.getBookById(bookId);
        model.addAttribute("book", book);

        return "book";
    }


    @RequestMapping("/newbook")
    public String showNewAccount(Model model) {

        model.addAttribute("book", new Book());
        model.addAttribute("genre", initializeGenre());
        return "createbook";
    }
    @RequestMapping(value="/docreate", method= RequestMethod.POST)
    public String createAccount(@Valid Book book, BindingResult result, @RequestParam(value="file", required=true)
    MultipartFile pdffile) {

        if(result.hasErrors()) {
            return "createbook";
        }

        try {
            if(!pdffile.isEmpty()) {
                validateImage(pdffile);// Проверить файл

                booksService.save(book, pdffile); // Сохранить книгу и файл
            }
        } catch (BookUploadException e) {
            result.reject(e.getMessage());
            return "createbook";
        }


        return "bookcreated";
    }

    @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
    public String search(Model model, @RequestParam("searchText") String searchText) throws Exception
    {
        List<Book> allFound = booksService.searchForBook(searchText);

        model.addAttribute("searchText", searchText);
        model.addAttribute("bookList", allFound);
        return "books";
    }

    @RequestMapping(value = "/get/{filename}", method = RequestMethod.GET)
    public String showBook(Model model, @PathVariable String filename) {


        return "book";
    }

    private void validateImage(MultipartFile image) throws BookUploadException {
        if(!image.getContentType().equals("application/pdf")) {
            throw new BookUploadException("Only PDF files accepted");
        }
    }

    @ModelAttribute("genre")
    public List<String> initializeGenre() {

        Locale defaultLocale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("messages", defaultLocale);

        List<String> genre = new ArrayList<String>();
        genre.add(bundle.getString("genre.sifi"));
        genre.add(bundle.getString("genre.drama"));
        genre.add(bundle.getString("genre.romance"));
        genre.add(bundle.getString("genre.mystery"));
        genre.add(bundle.getString("genre.health"));
        genre.add(bundle.getString("genre.child"));
        genre.add(bundle.getString("genre.religion"));
        genre.add(bundle.getString("genre.science"));
        genre.add(bundle.getString("genre.history"));
        genre.add(bundle.getString("genre.poetry"));
        genre.add(bundle.getString("genre.cook"));
        genre.add(bundle.getString("genre.bio"));
        genre.add(bundle.getString("genre.fantasy"));

        return genre;
    }
}
