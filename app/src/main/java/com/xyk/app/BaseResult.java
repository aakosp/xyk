package com.xyk.app;

public class BaseResult<T> {
    public String code;
    public String msg;
    public T data;

    public BaseResult() {
    }

    public BaseResult(T data) {
        code = "0";
        if (null == data) {
            this.msg = "暂无数据";
        }
        this.data = data;
    }
}
