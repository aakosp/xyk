package com.xyk.app.domian;

import java.util.List;

public class Page<T> {
    public long totalPage;
    public int currentPage;
    public int pageSize;
    public List<T> data;
}
