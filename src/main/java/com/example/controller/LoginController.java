package com.example.controller;

import com.example.biz.MenuBiz;
import com.example.biz.RoleBiz;
import com.example.biz.RoleMenuBiz;
import com.example.biz.UserRoleBiz;
import com.example.entity.MsTree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/29 14:54
 */
@Controller
public class LoginController {

    @Autowired
    private MenuBiz menuBizImpl;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String loginName, String password, Model model) {
        //登录验证
        System.out.println(loginName + "-----" + password);
        //获取shiro的主体
        Subject subject = SecurityUtils.getSubject();
        //构建用户登录令牌
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(loginName, password);

        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            model.addAttribute("message", "用户名错误");
            return "/login";
        }
        catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "密码错误");
            return "/login";
        }

        //将要去index页面之前，保存部分数据到model
        model.addAttribute("loginName", loginName);
        //放入所有的菜单，根据当前登录的用户
        List<MsTree> menuList = menuBizImpl.selectMenuByUserLoginName(loginName);
        model.addAttribute("menus", menuList);
        return "/menu/index";
    }

    /**
     * 注销
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }

}
