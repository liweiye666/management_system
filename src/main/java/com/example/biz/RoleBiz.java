package com.example.biz;

import com.example.entity.Role;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
public interface RoleBiz {

    Role selectByPrimaryKey(Integer roleId);
}
