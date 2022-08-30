package com.intsuho.book.test;

import com.intsuho.book.dao.UserDao;
import com.intsuho.book.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {

    @Test
    void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    void saveUser() {
    }

    @Test
    void queryUserByUsernameAndPassword() {
    }
}