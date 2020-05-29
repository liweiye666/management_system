package com.example.controller;

import com.example.biz.RoleBiz;
import com.example.biz.UserRoleBiz;
import com.example.entity.Role;
import com.example.entity.UserRole;
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

    @RequestMapping("/testRole")
    public String testRole() {

        List<UserRole> list = userRoleBizImpl.selectByUserId(2);
        if (list == null) {
            System.out.println("list is null");
        }
        else {
            System.out.println("list not null");
            System.out.println(list.size());
            UserRole userRole = list.get(0);
            System.out.println(userRole);
        }

        Role role = roleBizImpl.selectByPrimaryKey(1);
        String roleName = role.getRoleName();
        System.out.println(roleName);
        return "/login";
    }
}
