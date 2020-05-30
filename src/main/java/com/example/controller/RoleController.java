package com.example.controller;

import com.example.biz.RoleBiz;
import com.example.entity.Dept;
import com.example.entity.MsJson;
import com.example.entity.Role;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //查询部门所有数据
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
}
