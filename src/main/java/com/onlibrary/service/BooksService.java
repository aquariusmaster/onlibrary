package com.onlibrary.service;

import com.onlibrary.entity.Book;
import com.onlibrary.exception.BookUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by harkonnen on 25.03.16.
 */
public interface BooksService {


    Book getBookById(int id);
    void save(Book book, MultipartFile pdffile) throws BookUploadException;
    void delete(int bookId);
    List<Book> getAllBooks();
    public List<Book> searchForBook(String searchText) throws Exception;
}
