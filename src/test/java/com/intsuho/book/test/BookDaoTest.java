package com.intsuho.book.test;

import com.intsuho.book.dao.BookDao;
import com.intsuho.book.dao.impl.BookDaoImpl;
import com.intsuho.book.pojo.Book;
import com.intsuho.book.pojo.Page;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        bookDao.addBook(new Book(null, "aaa", "19", new BigDecimal(9999),2,0,null));
    }

    @Test
    void deleteBook() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void updateBookById() {
    }

    @Test
    void queryBooks() {
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for (Book book :
                bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }
}