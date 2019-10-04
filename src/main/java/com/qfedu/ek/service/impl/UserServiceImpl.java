package com.qfedu.ek.service.impl;

import com.qfedu.ek.dao.UserDao;
import com.qfedu.ek.entity.User;
import com.qfedu.ek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;


    @Override
    public User login(String account, String password) {
        User user = userDao.findByAccount(account);
        System.out.println(account);
        if (user == null){
            throw new RuntimeException("用户名错误！！");
        }
        if (!password.equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public void add(String nickname,String account, String password, String passwordagain) {

        if (nickname == null){
            throw new RuntimeException("请输入昵称！！");
        }
        if (account == null){
            throw new RuntimeException("请输入账户！！");
        }
        User user = userDao.findByAccount(account);
        if (user!= null){
            throw new RuntimeException("用户名已存在！！");
        }
        if (password == null){
            throw new RuntimeException("请输入密码");
        }
        if (passwordagain==null){
            throw new RuntimeException("请再次输入密码");
        }
        if (!password.equals(passwordagain)){
            throw new RuntimeException("两次密码不一致");
        }

        User user1 = new User();
        user1.setPassword(password);
        user1.setAccount(account);
        userDao.add(user1);
    }
}
