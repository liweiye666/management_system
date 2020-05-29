package com.example.biz.impl;

import com.example.biz.UserRoleBiz;
import com.example.dao.UserRoleMapper;
import com.example.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/29 18:20
 */
@Service
public class UserRoleBizImpl implements UserRoleBiz {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> selectByUserId(Integer userId) {
        return userRoleMapper.selectByUserId(userId);
    }
}
