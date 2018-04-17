package com.xyk.app.service.impl;

import com.xyk.app.dao.UserDao;
import com.xyk.app.domian.Admin;
import com.xyk.app.domian.Pension;
import com.xyk.app.domian.User;
import com.xyk.app.domian.UserYl;
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
    public UserYl userInfo(Long uid) {
        return userDao.userInfo(uid);
    }

    @Override
    public void delete(Long uid) {
        userDao.delete(uid);
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
    public void saveOrUpdate(UserYl user) {
        if (null != user.id){
            userDao.update(user);
        }else{
            userDao.save(user);
        }
    }

    @Override
    public List<Pension> pension(Long uid) {
        return userDao.pension(uid);
    }

    @Override
    public void updatePension(List<Pension> pensions) {
        for (Pension item : pensions) {
            userDao.updatePension(item);
        }
    }
}
