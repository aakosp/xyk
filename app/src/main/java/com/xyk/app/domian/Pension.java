package com.xyk.app.domian;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Pension {
    public Long id;//条目id
    public Integer uid;//用户id
    @JSONField(format="yyyy-MM")
    public Date beginDate;//条目起始时间
    public int month;//几个月，根据次数循环生成相应条数条目
    public double paymentSelf;//个人缴费
    public double paymentCompany;//单位缴费
    public double paymentBase;//缴费基数
}
