package com.xyk.app.dao;

import com.xyk.app.domian.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int login(@Param("admin") Admin admin);

    void delete(@Param("uid") Long uid);

    UserPension userInfo(@Param("uid") Long uid);

    long total();

    List<User> pageUser(@Param("offset")int offset, @Param("limit")int limit);

    List<User> search(@Param("key") String key);

    void save(UserYl user);

    void update(UserYl user);

    List<Pension> pension(Long uid);

    void savePension(Pension pension);

    void updatePension(Pension pension);

    void delPension(Long id);
}
