package com.onlibrary.dao;

import com.onlibrary.entity.Book;
import com.onlibrary.exception.BookUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by harkonnen on 17.03.16.
 */
public interface BooksDao {

    Book getBookById(int id);
    void save(Book book, MultipartFile pdffile) throws BookUploadException;
    void delete(int bookId);
    List<Book> getAllBooks();

}
