package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/29 11:25
 */

@Controller
public class PageController {

    //登录页面跳转
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "/login";
    }

    //用户管理界面跳转
    @RequestMapping("/toUser")
    public String toUser(){
        return "menu/userdb.html";
    }

    //菜单管理界面跳转
    @RequestMapping("/toMenu")
    public String toMenu(){
        return "menu/menudb.html";
    }

    //角色管理界面跳转
    @RequestMapping("/toRole")
    public String toRole(){
        return "menu/roledb.html";
    }

    //部门管理界面跳转
    @RequestMapping("/toDept")
    public String toDept(){
        return "menu/deptdb.html";
    }

    //登录页面跳转
    @RequestMapping(value = "/toUnau")
    public String toUnau() {
        return "menu/showMenuTree2";
    }
}
