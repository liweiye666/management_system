package com.example.biz.impl;

import com.example.biz.UserBiz;
import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/28 23:42
 */
@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }
}
