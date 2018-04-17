package com.xyk.app.dao;

import com.xyk.app.domian.Admin;
import com.xyk.app.domian.Pension;
import com.xyk.app.domian.User;
import com.xyk.app.domian.UserYl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int login(@Param("admin") Admin admin);

    void delete(@Param("uid") Long uid);

    UserYl userInfo(@Param("uid") Long uid);

    List<User> pageUser(@Param("page") Integer page);

    List<User> search(@Param("key") String key);

    void save(UserYl user);

    void update(UserYl user);

    List<Pension> pension(Long uid);

    int updatePension(Pension pension);
}
