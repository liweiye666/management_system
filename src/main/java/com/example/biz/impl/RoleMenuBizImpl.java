package com.example.biz.impl;

import com.example.biz.RoleMenuBiz;
import com.example.dao.RoleMenuMapper;
import com.example.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/29 19:04
 */
@Service
public class RoleMenuBizImpl implements RoleMenuBiz {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Integer> selectMenuIdByRoleId(Integer roleId) {
        return roleMenuMapper.selectMenuIdByRoleId(roleId);
    }
}
