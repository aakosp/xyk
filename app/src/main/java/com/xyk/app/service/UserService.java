package com.xyk.app.service;

import com.xyk.app.domian.Admin;
import com.xyk.app.domian.Pension;
import com.xyk.app.domian.User;
import com.xyk.app.domian.UserYl;

import java.util.List;

public interface UserService {

    boolean login(Admin admin);

    UserYl userInfo(Long uid);

    void delete(Long uid);

    List<User> search(String key);

    List<User> userPage(int page);

    void saveOrUpdate(UserYl user);

    List<Pension> pension(Long uid);

    void updatePension(List<Pension> pensions);
}
