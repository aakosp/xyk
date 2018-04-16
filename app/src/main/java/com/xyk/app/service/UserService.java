package com.xyk.app.service;

import com.xyk.app.domian.Admin;
import com.xyk.app.domian.User;

import java.util.List;

public interface UserService {

    boolean login(Admin admin);

    User user(Long uid);

    List<User> search(String key);

    List<User> userPage(int page);

    int save(User user);

    void update(User user);
}
