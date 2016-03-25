package com.onlibrary.service;

import com.onlibrary.dao.BooksDao;
import com.onlibrary.entity.Book;
import com.onlibrary.exception.BookUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by harkonnen on 25.03.16.
 */
@Service("booksService")
public class BooksHibernateService implements BooksService {

    @Autowired
    BooksDao booksDao;

    public Book getBookById(int id) {
        return booksDao.getBookById(id);
    }

    public void save(Book book, MultipartFile pdffile) throws BookUploadException {
        booksDao.save(book, pdffile);
    }

    public void delete(int bookId) {
        booksDao.delete(bookId);
    }

    public List<Book> getAllBooks() {
        return booksDao.getAllBooks();
    }

    public List<Book> searchForBook(String searchText) throws Exception {
        return booksDao.searchForBook(searchText);
    }
}
