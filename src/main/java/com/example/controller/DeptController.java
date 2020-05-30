package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.biz.DeptBiz;
import com.example.entity.Dept;
import com.example.entity.MsJson;
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

    //添加部门
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    @ResponseBody
    public Object addDept(Dept record){
        Map map = (Map) deptBizImpl.insert(record);
        return map;
    }

    //删除部门
    @RequestMapping(value = "/deleteDept",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteDept(Integer deptId){
        Map map = (Map) deptBizImpl.deleteByPrimaryKey(deptId);
        return map;
    }

    //批量删除部门
    @RequestMapping(value = "/delDept",method = RequestMethod.POST)
    @ResponseBody
    public Object delDept( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<Integer> list= (List<Integer>) JSON.parse(ids);
        int i = deptBizImpl.delDeptByID(list);
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

    //编辑部门信息
    @RequestMapping(value = "/editDept",method = RequestMethod.POST)
    @ResponseBody
    public Object editDept(Dept record){
        Map map = (Map) deptBizImpl.updateByPrimaryKey(record);
        return map;
    }
}
