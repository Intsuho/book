package com.intsuho.book.web;

import com.intsuho.book.pojo.Book;
import com.intsuho.book.pojo.Page;
import com.intsuho.book.service.BookService;
import com.intsuho.book.service.impl.BookServiceImpl;
import com.intsuho.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo,pageSize)获取Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.保存Page对象到Request域中
        req.setAttribute("page",page);
        //4.请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}

