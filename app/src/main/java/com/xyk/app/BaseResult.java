package com.xyk.app;

public class BaseResult<T> {
    public String code;
    public String msg;
    public T t;

    public BaseResult() {
    }

    public BaseResult(T t) {
        code = "0";
        if (null == t) {
            this.msg = "暂无数据";
        }
        this.t = t;
    }
}
