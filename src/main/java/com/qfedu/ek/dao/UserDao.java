package com.qfedu.ek.dao;

import com.qfedu.ek.entity.User;

public interface UserDao {
    public User findByAccount(String account);

    public void add(User user);
}
