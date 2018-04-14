package com.xyk.app.controller;

import com.xyk.app.BaseResult;
import com.xyk.app.domian.Admin;
import com.xyk.app.domian.User;
import com.xyk.app.domian.UserYl;
import com.xyk.app.util.MD5Util;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(@RequestBody Admin admin) {
        BaseResult baseResult = new BaseResult();
        if ("abc".equals(admin.name) && "123".equals(admin.pwd)) {
            baseResult.code = "0";
        } else {
            baseResult.code = "1";
            baseResult.msg = "用户名或密码错误";
        }
        String origin = admin.name + "a" + System.currentTimeMillis() + MD5Util.md5(admin.pwd);
        String sessionKey = Base64Utils.encodeToString(origin.getBytes());
        Map<String, String> result = new HashMap<>(1);
        result.put("sessionId", sessionKey);
        baseResult.t = result;
        return baseResult;
    }

    @RequestMapping(value = "/user/page/{pageNum}", method = RequestMethod.GET)
    public BaseResult listUser(@PathVariable("pageNum") int pageNum) {
        BaseResult baseResult = new BaseResult(pageNum);
        return baseResult;
    }

    @RequestMapping(value = "/user/search/{key}", method = RequestMethod.GET)
    public BaseResult searchUser(@PathVariable("key") String key) {
        BaseResult baseResult = new BaseResult(key);
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

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public BaseResult listUser(@PathVariable("id") long id) {
        BaseResult baseResult = new BaseResult();
        baseResult.code = "0";
        baseResult.msg = "操作成功";
        return baseResult;
    }
}
