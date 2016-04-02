package com.onlibrary.dao;

import com.onlibrary.entity.Book;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;


import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by harkonnen on 02.04.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@TestExecutionListeners(listeners={ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
public class BooksHibernateDaoTest extends TestCase {


    @Autowired
    BooksDao booksDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = booksDao.getAllBooks();
        assertEquals("Books size must be 1", books.size(), 2);
    }

    @Test
    public void testGetBookById() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testSearchForBook() throws Exception {

    }
}