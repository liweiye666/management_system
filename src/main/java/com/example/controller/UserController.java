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
public class UserController {

    @RequestMapping("/tolgoin")
    public String toLogin(){
        return "login.html";
    }
}
