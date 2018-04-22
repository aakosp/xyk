package com.xyk.app.service.impl;

import com.xyk.app.dao.UserDao;
import com.xyk.app.domian.*;
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
    public UserPension userInfo(Long uid) {
        UserPension userPension = userDao.userInfo(uid);
        if (null != userPension) {
            userPension.pension = userDao.pension(uid);
        }
        return userPension;
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
    public Page<User> userPage(int page) {
        int pageSize = 15;
        if (page < 1){
            page = 1;
        }

        int offset = (page-1) * pageSize;
        Page<User> users = new Page<>();
        users.totalPage = userDao.total();
        users.pageSize = 15;
        users.currentPage = page;
        if (users.totalPage > 0 ){
            users.totalPage = (long) Math.ceil(Double.valueOf(users.totalPage) / 15D);
            users.data = userDao.pageUser(offset, 15);
        }
        return users;
    }

    @Override
    public void saveOrUpdate(UserYl user) {
        if (null != user.id) {
            userDao.update(user);
        } else {
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
            if (null != item.id) {
                userDao.updatePension(item);
            } else {
                userDao.savePension(item);
            }
        }
    }

    @Override
    public void deletePension(Long id) {
        userDao.delete(id);
    }
}
