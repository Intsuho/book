package com.intsuho.book.dao;

import com.intsuho.book.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);
}
