package com.example.biz;

import com.example.entity.Dept;
import com.example.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
public interface RoleBiz {

    Role selectByPrimaryKey(Integer roleId);
    PageInfo<Role> selectAllDept(int page, int limit);
    Object insert(Role record);
    int delRoleByID(List<Integer> ids);
    Object updateByPrimaryKey(Role record);
    Object deleteByPrimaryKey(Integer deptId);
    List<Role> selectAll();
}
