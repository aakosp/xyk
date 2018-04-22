package com.xyk.app.controller;

import com.xyk.app.BaseResult;
import com.xyk.app.domian.UserPension;
import com.xyk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/user")
public class ShowController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public BaseResult user(@PathVariable("uid") Long uid) {
        UserPension user = userService.userInfo(uid);
        if (null != user.expiry){
            Date now = new Date(System.currentTimeMillis());
            if(now.after(user.expiry)){
                BaseResult<UserPension> baseResult = new BaseResult();
                baseResult.code = "2";
                baseResult.msg = "无效数据";
                return baseResult;
            }
        }
        BaseResult<UserPension> baseResult = new BaseResult(user);
        return baseResult;
    }
}
