package com.onlibrary.dao;

import com.onlibrary.entity.Book;

import java.util.List;

/**
 * Created by harkonnen on 17.03.16.
 */
public interface BooksDao {

    Book getBookById(int id);
    void save(Book book);
    void delete(int bookId);
    List<Book> getAllBooks();

}
