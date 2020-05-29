package com.example.biz.impl;

import com.example.biz.RoleBiz;
import com.example.dao.RoleMapper;
import com.example.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
