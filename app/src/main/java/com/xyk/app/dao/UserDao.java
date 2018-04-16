package com.xyk.app.dao;

import com.xyk.app.domian.Admin;
import com.xyk.app.domian.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int login(@Param("admin") Admin admin);

    User user(@Param("uid") Long uid);

    List<User> pageUser(@Param("page") Integer page);

    List<User> search(@Param("key") String key);

    int save(User user);
}
