package com.example.biz.impl;

import com.example.biz.DeptBiz;
import com.example.dao.DeptMapper;
import com.example.entity.Dept;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 利伟业
 * @Date: 2020/5/29 17:06
 */
@Service
public class DeptBIzImpl implements DeptBiz {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public PageInfo<Dept> selectAllDept(int page, int limit) {
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        List<Dept> myUserInfos = deptMapper.selectAllDept();
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Dept> pageInfo = new PageInfo(myUserInfos);
        return pageInfo;
    }
}
