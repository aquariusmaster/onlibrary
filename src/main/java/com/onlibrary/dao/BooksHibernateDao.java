package com.onlibrary.dao;

import com.onlibrary.entity.Book;
import com.onlibrary.dao.BooksDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by harkonnen on 15.03.16.
 */

@Transactional
@Repository("booksDao")
public class BooksHibernateDao implements BooksDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Book> getAllBooks() {

        Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Book");
        return  query.list();

    }

    public Book getBookById(int id) {
//
        Session session = this.sessionFactory.getCurrentSession();
        return (Book)session.get(Book.class, id);
    }

    @Transactional
    public void save(Book book) {

        this.sessionFactory.getCurrentSession().save(book);
    }



    @Transactional
    public void delete(int bookId) {

    }
}
