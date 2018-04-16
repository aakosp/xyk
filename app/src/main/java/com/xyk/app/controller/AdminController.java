package com.xyk.app.controller;

import com.xyk.app.BaseResult;
import com.xyk.app.domian.Admin;
import com.xyk.app.domian.Pension;
import com.xyk.app.domian.User;
import com.xyk.app.domian.UserYl;
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
            baseResult.t = result;
        } else {
            baseResult.code = "1";
            baseResult.msg = "用户名或密码错误";
        }
        return baseResult;
    }

    @RequestMapping(value = "/user/page/{pageNum}", method = RequestMethod.GET)
    public BaseResult listUser(@PathVariable("pageNum") Integer pageNum) {
        BaseResult baseResult = new BaseResult(pageNum);
        return baseResult;
    }

    @RequestMapping(value = "/user/search/{key}", method = RequestMethod.GET)
    public BaseResult searchUser(@PathVariable("key") String key) {
        BaseResult baseResult = new BaseResult(key);
        return baseResult;
    }

    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public BaseResult user(@PathVariable("uid") Long uid) {
        User user = userService.user(uid);
        BaseResult baseResult = new BaseResult(user);
        return baseResult;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public BaseResult updateUser(@RequestBody UserYl user) {
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public BaseResult deleteUser(@PathVariable("id") long id) {
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }

    @RequestMapping(value = "/user/pension/{id}", method = RequestMethod.GET)
    public BaseResult userPension(@PathVariable("id") long id) {
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }

    @RequestMapping(value = "/user/pension/update", method = RequestMethod.POST)
    public BaseResult updateUserPension(@RequestBody List<Pension> pension) {
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }
}
