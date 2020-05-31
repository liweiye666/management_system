package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.biz.MenuBiz;
import com.example.entity.Dept;
import com.example.entity.Menu;
import com.example.entity.MsJson;
import com.example.entity.MsTree;
import com.example.util.MyConstants;
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
 * @Date: Created in 2020/5/29 17:19
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuBiz menuBizImpl;

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<MsTree> selectAllMenu(){
        List<MsTree> layUiTrees = menuBizImpl.selectAllMenu();
        return layUiTrees;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(){
        List<Menu> menus = menuBizImpl.selectAll();
        MsJson msJson = new MsJson();
        msJson.setCode(0);
        msJson.setMsg("");
        msJson.setCount(menus.size());
        msJson.setData(menus);
        return msJson;
    }

    //添加菜单
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    @ResponseBody
    public Object addDept(Menu record){
        Map map = (Map) menuBizImpl.insert(record);
        return map;
    }

    //批量删除菜单
    @RequestMapping(value = "/delMenu",method = RequestMethod.POST)
    @ResponseBody
    public Object delDept( @RequestParam(value = "ids") String  ids){
        //将json字符串转换成list对象
        List<Integer> list= (List<Integer>) JSON.parse(ids);
        int i = menuBizImpl.delMenuByID(list);
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

    //删除部门
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.GET)
    @ResponseBody
    public Object deleteMenu(Integer menuId){
        Map map = (Map) menuBizImpl.deleteByPrimaryKey(menuId);
        return map;
    }

    //编辑菜单信息
    @RequestMapping(value = "/editMenu",method = RequestMethod.POST)
    @ResponseBody
    public Object editDept(Menu record){
        Map map = (Map) menuBizImpl.updateByPrimaryKey(record);
        return map;
    }
}
