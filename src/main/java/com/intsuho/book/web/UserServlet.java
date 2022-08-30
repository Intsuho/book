package com.intsuho.book.web;

import com.intsuho.book.pojo.User;
import com.intsuho.book.service.UserService;
import com.intsuho.book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //处理登录
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用userService.Login()登录处理业务
        User loginUser =  userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //把错误信息和回显表单项信息保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username", username);
            //登录失败，请求转发
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else{
            //登录成功，请求转发
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //处理注册
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)){
                System.out.println("用户名[" + username + "]已经存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{

                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }else{
            System.out.println("验证码" + code + "错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
