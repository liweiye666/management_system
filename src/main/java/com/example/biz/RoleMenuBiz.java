package com.example.biz;

import com.example.entity.RoleMenu;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 19:03
 */
public interface RoleMenuBiz {

    List<Integer> selectMenuIdByRoleId(Integer roleId);

    int insert(RoleMenu record);
}
