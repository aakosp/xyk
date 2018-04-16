package com.xyk.app.service.impl;

import com.xyk.app.dao.UserDao;
import com.xyk.app.domian.Admin;
import com.xyk.app.domian.User;
import com.xyk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean login(Admin admin) {
        int count = userDao.login(admin);
        return count > 0;
    }

    @Override
    public User user(Long uid) {
        return userDao.user(uid);
    }

    @Override
    public List<User> search(String key) {
        return userDao.search(key);
    }

    @Override
    public List<User> userPage(int page) {
        return userDao.pageUser(page);
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public void update(User user) {

    }
}
