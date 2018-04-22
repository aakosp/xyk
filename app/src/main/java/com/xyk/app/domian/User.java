package com.xyk.app.domian;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    public Long id;//用户id
    public String name;//用户姓名
    public String idCard;//	身份证号
    public int sex;//性别:0:女 1:男
    public String birthday;//生日
    public String company;//生日
    @JSONField(format="yyyy-MM-dd")
    public Date expiry;//失效时间
}
