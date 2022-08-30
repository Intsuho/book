package com.intsuho.book.web;

import com.intsuho.book.pojo.Book;
import com.intsuho.book.pojo.Page;
import com.intsuho.book.service.BookService;
import com.intsuho.book.service.impl.BookServiceImpl;
import com.intsuho.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);//分页功能得到的pageNo
        pageNo+=1;//添加数据，永远到最后一页（溢出一页的情况，如果没溢出一页，那么setpageNo()会修正）
        //1.获取请求的参数，封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.addBook()来保存图书
        bookService.addBook(book);
        //3.跳转到图书列表页面(要用重定向)
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.通过bookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3.请求转发到/pages/manager/book_manager.jsp下
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        //3.通过重定向返回图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));//分页功能得到的pageNo
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过req得到传过来的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.通过id查书
        bookService.deleteBookById(id);
        //3.通过重定向返回图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page" + req.getParameter("pageNo"));//分页功能得到的pageNo
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求得参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3.保存到图书到request域中
        req.setAttribute("book", book);
        //4.请求转发(不用重定向的原因是，要用到request域，重定向request域就没了)
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo,pageSize)获取Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.保存Page对象到Request域中
        req.setAttribute("page",page);
        //4.请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
