package com.intsuho.book.dao;

import com.intsuho.book.pojo.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    /**
     * 增加一条图书信息
     * @param book 图书信息
     * @return
     */
    public int addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book updateBookById(Integer io);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
    List<Book> queryForPageItemsForRange(int begin, int pageSize, int min, int max);
}
