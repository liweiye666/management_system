package com.example.biz;

import com.example.entity.UserRole;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 19:24
 */
public interface UserRoleBiz {

    Integer selectRoleIdByUserId(Integer userId);

    int insert(UserRole record);
}
