package com.example.controller;

import com.example.biz.MenuBiz;
import com.example.entity.Dept;
import com.example.entity.Menu;
import com.example.entity.MsJson;
import com.example.entity.MsTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private MenuBiz menuBiz;

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<MsTree> selectAllMenu(){
        List<MsTree> layUiTrees = menuBiz.selectAllMenu();
        return layUiTrees;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(){
        List<Menu> menus = menuBiz.selectAll();
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
        Map map = (Map) menuBiz.insert(record);
        return map;
    }
}
