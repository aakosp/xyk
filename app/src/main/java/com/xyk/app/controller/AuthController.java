package com.xyk.app.controller;

import com.xyk.app.BaseResult;
import com.xyk.app.domian.Admin;
import com.xyk.app.service.UserService;
import com.xyk.app.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
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
}
