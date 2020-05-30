package com.example.biz.impl;

import com.example.biz.RoleBiz;
import com.example.dao.RoleMapper;
import com.example.entity.Dept;
import com.example.entity.Role;
import com.example.util.MyConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Object insert(Role record) {
        int i = roleMapper.insert(record);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    @Override
    public int delRoleByID(List<Integer> ids) {
        return roleMapper.delRoleByID(ids);
    }
}
