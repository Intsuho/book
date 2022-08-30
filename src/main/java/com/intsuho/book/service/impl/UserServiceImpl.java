package com.intsuho.book.service.impl;

import com.intsuho.book.dao.UserDao;
import com.intsuho.book.dao.impl.UserDaoImpl;
import com.intsuho.book.pojo.User;
import com.intsuho.book.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
