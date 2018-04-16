package com.xyk.app.domian;

public class Pension {
    public int id;//条目id
    public int uid;//用户id
    public String beginDate;//条目起始时间
    public int month;//几个月，根据次数循环生成相应条数条目
    public double paymentSelf;//个人缴费
    public double paymentCompany;//单位缴费
    public double paymentBase;//缴费基数
}
