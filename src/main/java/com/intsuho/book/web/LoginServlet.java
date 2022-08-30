package com.intsuho.book.web;

import com.intsuho.book.pojo.User;
import com.intsuho.book.service.UserService;
import com.intsuho.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用userService.Login()登录处理业务
        User loginUser =  userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //登录失败，请求转发
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else{
            //登录成功，请求转发
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
