package com.intsuho.book.service;

import com.intsuho.book.pojo.Book;
import com.intsuho.book.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> page(Integer pageNo, Integer pageSize);
}
