package com.example.biz.impl;

import com.example.biz.RoleBiz;
import com.example.dao.RoleMapper;
import com.example.entity.Dept;
import com.example.entity.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
@Service
public class RoleBizImpl implements RoleBiz {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public PageInfo<Role> selectAllDept(int page, int limit) {
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        List<Role> myUserInfos = roleMapper.selectAllRole();
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Role> pageInfo = new PageInfo(myUserInfos);
        return pageInfo;
    }
}
