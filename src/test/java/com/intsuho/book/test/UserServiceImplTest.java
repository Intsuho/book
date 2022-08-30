package com.intsuho.book.test;

import com.intsuho.book.pojo.User;
import com.intsuho.book.service.UserService;
import com.intsuho.book.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    void registUser() {
        userService.registUser(new User(null, "bbj168", "6666", "bbj168@qq.com"));
    }

    @Test
    void login() {
    }

    @Test
    void existUsername() {
    }
}