package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.biz.RoleBiz;
import com.example.biz.RoleMenuBiz;
import com.example.entity.*;
import com.example.util.MyConstants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @Autowired
    private RoleMenuBiz roleMenuBizImpl;

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
        System.out.println("角色");
        Map map = (Map)roleBizImpl.insert(role);
        return map;
    }

    //角色菜单中间表
    @RequestMapping(value = "/insertRoleMenu")
    @ResponseBody
    public Object insertRoleMenu(int roleId, @RequestParam(value = "df") String df) {
        System.out.println("权限");
        List<?> list = (List<?>) JSON.parse(df);
        String str = list.toString();

        //字符串匹配方式获取list中的所有id，存放如idList中
        int index = 0;
        int flag = 0;
        List<Integer> idList = new ArrayList<>();
        int id;
        int j;
        char c;
        String idStr = "";
        for (j = 0; j<str.length(); j++) {
            index = str.indexOf("id\":", flag);
            index += 4;
            for (;;) {
                c = str.charAt(index);
                if (c >= '0' && c <= '9') {
                    idStr += c;
                    index ++;
                }
                else {
                    break;
                }
            }
            if (idStr != "") {
                id = Integer.parseInt(idStr);
                if (idList.size() == 0) {
                    idList.add(id);
                } else {
                    int idList0 = idList.get(0);
                    if (id == idList0) {
                        break;
                    } else {
                        idList.add(id);
                    }
                }
            }
            idStr = "";
            flag = index + 5;
        }

        int i = 1;
        int a;
        int menuId;
        for (j = 0; j < idList.size(); j ++) {
            menuId = idList.get(j);
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            a = roleMenuBizImpl.insert(roleMenu);
            if (a <=1) {
                i = 0;
            }
        }

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
