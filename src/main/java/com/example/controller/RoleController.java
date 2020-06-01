package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.biz.RoleBiz;
import com.example.entity.*;
import com.example.util.MyConstants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleBiz roleBizImpl;

    //查询角色所有数据
    @RequestMapping("/selectAll")
    @ResponseBody
    public MsJson selectAll(int page, int limit){
        //开始查询
        PageInfo<Role> pageInfo = roleBizImpl.selectAllDept(page, limit);
        MsJson json = new MsJson();
        json.setCode(0);
        json.setMsg("返回消息");
        //设置分页之后的返回值
        json.setCount(pageInfo.getTotal());
        json.setData(pageInfo.getList());
        return json;
    }

    //添加角色
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @ResponseBody
    public Object addRole(Role role){
       Map map = (Map)roleBizImpl.insert(role);
       return map;
    }

    @RequestMapping(value = "/insertRoleMenu")
    @ResponseBody
    public Object insertRoleMenu(@RequestParam(value = "df") String df) {
        System.out.println("权限");
        List<MsTree> list = (List<MsTree>) JSON.parse(df);

        System.out.println(list);

        int i = 1;// = roleMenuBizImpl.insert(roleMenu);
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

    //批量删除角色
    @RequestMapping(value = "/delRole",method = RequestMethod.POST)
    @ResponseBody
    public Object delRole( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<Integer> list= (List<Integer>) JSON.parse(ids);
        int i = roleBizImpl.delRoleByID(list);
        Map map= new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

    //编辑角色信息
    @RequestMapping(value = "/editRole",method = RequestMethod.POST)
    @ResponseBody
    public Object editDept(Role record){
        System.out.println(record);
        Map map = (Map) roleBizImpl.updateByPrimaryKey(record);
        return map;
    }

    //删除角色
    @RequestMapping(value = "/deleteRole",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteDept(Integer roleId){
        Map map = (Map) roleBizImpl.deleteByPrimaryKey(roleId);
        return map;
    }
}
