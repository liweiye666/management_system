package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.biz.RoleBiz;
import com.example.biz.UserBiz;
import com.example.biz.UserRoleBiz;
import com.example.entity.MsJson;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.shiro.ShiroUtil;
import com.example.util.MyConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/28 23:14
 */

@Controller
@RequestMapping("/user")//窄化请求
public class UserController {

    @Autowired
    private UserBiz userBizImpl;

    @Autowired
    private RoleBiz roleBizImpl;

    @Autowired
    private UserRoleBiz userRoleBizImpl;

    @RequestMapping("/selectAllUser")
    @ResponseBody
    public Object selectAllUser(int page, int limit){
        //开始分页
        PageHelper.startPage(page, limit);
        //开始查询
        //(开始分页和开始查询的代码之间不能有其他任何不相关的代码)
        List<User> userList = userBizImpl.selectAllUser();
        //结束分页
        PageInfo<User> pageInfo = new PageInfo<>(userList);

        MsJson json = new MsJson();
        json.setCode(0);
        json.setMsg("返回消息");
        json.setCount(pageInfo.getTotal());
        json.setData(pageInfo.getList());
        return json;
    }

    @RequestMapping(value = "/insertUser")
    @ResponseBody
    public Object insertUser(User user){
        String salt = UUID.randomUUID().toString();
        String password = ShiroUtil.encryptionBySalt(salt, user.getPassword());
        user.setPassword(password);
        user.setSalt(salt);
        int i = userBizImpl.insertSelective(user);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.saveSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public Object updateUser(User user){
        int i = userBizImpl.updateByPrimaryKeySelective(user);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.editSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public Object deleteUser(@RequestParam(value = "ids") String ids){
        //将json字符串转换成list对象
        List<String> list = (List<String>) JSON.parse(ids);
        int i = userBizImpl.delUserByID(list);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.delSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.delFailMsg);
        }
        return map;
    }

    @RequestMapping(value = "/resetPassword")
    @ResponseBody
    public Object resetPassword(int userId, String newPassword) {
        String salt = UUID.randomUUID().toString();
        String password = ShiroUtil.encryptionBySalt(salt, newPassword);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setSalt(salt);
        int i = userBizImpl.updateByPrimaryKeySelective(user);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.editSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping(value = "/getRole")
    @ResponseBody
    public Object getRole() {
        List<Role> roleList =  roleBizImpl.selectAll();
        MsJson json = new MsJson();
        json.setCode(0);
        json.setMsg("角色下拉框");
        json.setCount(roleList.size());
        json.setData(roleList);
        return json;
    }

    @RequestMapping(value = "/setRole")
    @ResponseBody
    public Object setRole(UserRole userRole) {
        int i = userRoleBizImpl.insert(userRole);
        Map map = new HashMap<>();
        if (i > 0) {
            map.put("code", MyConstants.successCode);
            map.put("message", MyConstants.saveSuccessMsg);
        } else {
            map.put("code", MyConstants.failCode);
            map.put("message", MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping(value = "/selectByLoginName",method = RequestMethod.GET)
    @ResponseBody
    public Object selectByLoginName(String loginName) {
        User user = userBizImpl.selectByLoginName(loginName);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        MsJson json = new MsJson();
        json.setCode(0);
        json.setMsg("返回消息");
        json.setCount(100);
        json.setData(userList);
        return json;
    }

    //查看用户民是否存在
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkUserName(String loginName){
        return userBizImpl.checkUserLoginName(loginName);
    }
}
