package com.xyk.app.service;

import com.xyk.app.domian.*;

import java.util.List;

public interface UserService {

    boolean login(Admin admin);

    UserPension userInfo(Long uid);

    void delete(Long uid);

    List<User> search(String key);

    List<User> userPage(int page);

    void saveOrUpdate(UserYl user);

    List<Pension> pension(Long uid);

    void updatePension(List<Pension> pensions);
}
