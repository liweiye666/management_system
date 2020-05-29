package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/28 23:14
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "menu/index.html";
    }
}
