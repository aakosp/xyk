package com.xyk.app.controller;

import com.xyk.app.BaseResult;
import com.xyk.app.domian.*;
import com.xyk.app.service.UserService;
import com.xyk.app.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(@RequestBody Admin admin) {
        BaseResult baseResult = new BaseResult();
        boolean login = userService.login(admin);
        if (login) {
            baseResult.code = "0";
            baseResult.msg = "登陆成功";
            String origin = admin.name + "a" + System.currentTimeMillis() + MD5Util.md5(admin.pwd);
            String sessionKey = Base64Utils.encodeToString(origin.getBytes());
            Map<String, String> result = new HashMap<>(1);
            result.put("sessionId", sessionKey);
            baseResult.data = result;
        } else {
            baseResult.code = "1";
            baseResult.msg = "用户名或密码错误";
        }
        return baseResult;
    }

    @RequestMapping(value = "/user/page/{pageNum}", method = RequestMethod.GET)
    public BaseResult<Page<User>> listUser(@PathVariable("pageNum") Integer pageNum) {
        Page<User> users = userService.userPage(pageNum);
        BaseResult<Page<User>> baseResult = new BaseResult(users);
        return baseResult;
    }

    @RequestMapping(value = "/user/search/{key}", method = RequestMethod.GET)
    public BaseResult searchUser(@PathVariable("key") String key) {
        BaseResult<List<User>> baseResult = new BaseResult(userService.search(key));
        return baseResult;
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public BaseResult user(@PathVariable("uid") Long uid) {
        UserPension user = userService.userInfo(uid);
        BaseResult<UserPension> baseResult = new BaseResult(user);
        return baseResult;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public BaseResult updateUser(@RequestBody UserYl user) {
        BaseResult baseResult = new BaseResult();
        if (null == user) {
            baseResult.code = "1";
            baseResult.msg = "参数为空";
        } else {
            userService.saveOrUpdate(user);
            baseResult.code = "0";
            baseResult.msg = "操作成功";
        }

        return baseResult;
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public BaseResult deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }

    @RequestMapping(value = "/user/pension/{id}", method = RequestMethod.GET)
    public BaseResult<List<Pension>> userPension(@PathVariable("id") Long id) {
        BaseResult<List<Pension>> baseResult = new BaseResult();
        if (null == id) {
            baseResult.code = "1";
            baseResult.msg = "参数为空";
        } else {
            baseResult.code = "0";
            baseResult.msg = "操作成功";
            baseResult.data = userService.pension(id);
        }
        return baseResult;
    }

    @RequestMapping(value = "/user/pension/update", method = RequestMethod.POST)
    public BaseResult updateUserPension(@RequestBody List<Pension> pension) {
        userService.updatePension(pension);
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }

    @RequestMapping(value = "/user/pension/delete/{id}", method = RequestMethod.POST)
    public BaseResult deleteUserPension(@PathVariable("id") Long id) {
        userService.deletePension(id);
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }
}
