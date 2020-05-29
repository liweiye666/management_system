package com.example.controller;

import com.example.biz.RoleBiz;
import com.example.biz.RoleMenuBiz;
import com.example.biz.UserRoleBiz;
import com.example.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
@Controller
public class RoleController {

    @Autowired
    private RoleBiz roleBizImpl;

    @Autowired
    private UserRoleBiz userRoleBizImpl;

    @Autowired
    private RoleMenuBiz roleMenuBizImpl;

    @RequestMapping("/testRole")
    public String testRole() {

        int rid;
        rid = userRoleBizImpl.selectRoleIdByUserId(2);
        System.out.println("rid" + rid);


        List<Integer> list = roleMenuBizImpl.selectMenuIdByRoleId(rid);
        System.out.println("list_m:" + list.size());
        System.out.println("mid2:" + list.get(1));

        Role role = roleBizImpl.selectByPrimaryKey(1);
        String roleName = role.getRoleName();
        System.out.println(roleName);
        return "/login";
    }
}
