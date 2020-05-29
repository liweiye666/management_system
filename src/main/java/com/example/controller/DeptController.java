package com.example.controller;

import com.example.biz.DeptBiz;
import com.example.entity.Dept;
import com.example.entity.MsJson;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.controller
 * @Author: 利伟业
 * @Date: 2020/5/29 16:52
 */

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptBiz deptBizImpl;

    //查询部门所有数据
    @RequestMapping("/selectAll")
    @ResponseBody
    public MsJson selectAll(int page, int limit){
        //开始查询
        PageInfo<Dept> pageInfo = deptBizImpl.selectAllDept(page, limit);
        MsJson json = new MsJson();
        json.setCode(0);
        json.setMsg("返回消息");
        //设置分页之后的返回值
        json.setCount(pageInfo.getTotal());
        json.setData(pageInfo.getList());
        return json;
    }
}
