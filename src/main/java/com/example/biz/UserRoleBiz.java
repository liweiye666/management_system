package com.example.biz;

import com.example.entity.UserRole;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 18:20
 */
public interface UserRoleBiz {

    List<UserRole> selectByUserId(Integer userId);
}
