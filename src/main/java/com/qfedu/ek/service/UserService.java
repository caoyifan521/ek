package com.qfedu.ek.service;

import com.qfedu.ek.entity.User;

public interface UserService {

    public User login(String account,String password);

    public void add(String nickname,String account, String password,String passwordagain);
}
