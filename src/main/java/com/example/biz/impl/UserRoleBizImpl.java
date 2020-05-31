package com.example.biz.impl;

import com.example.biz.UserRoleBiz;
import com.example.dao.UserRoleMapper;
import com.example.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/29 19:24
 */
@Service
public class UserRoleBizImpl implements UserRoleBiz {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer selectRoleIdByUserId(Integer userId) {
        return userRoleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }
}
