package com.example.biz;

import com.example.entity.Dept;
import com.github.pagehelper.PageInfo;


public interface DeptBiz {

    PageInfo<Dept> selectAllDept(int page, int limit);
}
