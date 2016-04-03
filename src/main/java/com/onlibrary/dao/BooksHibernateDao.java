package com.onlibrary.dao;

import com.onlibrary.entity.Book;
import com.onlibrary.exception.BookUploadException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by harkonnen on 15.03.16.
 */

@Transactional
@Repository("booksDao")
public class BooksHibernateDao implements BooksDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = Logger.getLogger(BooksHibernateDao.class);

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
    public void save(Book book, MultipartFile pdffile) throws BookUploadException {

        String filename = pdffile.getOriginalFilename();
        try {
            File file = new File("onlibrary-storage/" + filename);
            FileUtils.writeByteArrayToFile(file, pdffile.getBytes());
            if( LOGGER.isInfoEnabled()){
                LOGGER.info("Book is saved in: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            LOGGER.error("Unable to save image", e);

            throw new BookUploadException("Unable to save image", e);

        }
        book.setFilename(filename);
        this.sessionFactory.getCurrentSession().saveOrUpdate(book);
    }



    @Transactional
    public void delete(int bookId) {
        Book toDelete = getBookById(bookId);
        String filename = toDelete.getFilename();
        Session session = this.sessionFactory.getCurrentSession();

        try {
            File file = new File("onlibrary-storage/" + filename);
            file.delete();
            session.delete(toDelete);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Transactional
    public List<Book> searchForBook(String searchText) throws Exception
    {
        try
        {
            Session session = this.sessionFactory.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Book.class).get();
            org.apache.lucene.search.Query query = qb
                    .keyword().onFields("description", "title", "author", "genre")
                    .matching(searchText)
                    .createQuery();

            org.hibernate.Query hibQuery =
                    fullTextSession.createFullTextQuery(query, Book.class);

            List<Book> results = hibQuery.list();
            return results;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
