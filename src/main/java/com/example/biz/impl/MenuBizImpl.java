package com.example.biz.impl;

import com.example.Util.TreeUtils;
import com.example.biz.MenuBiz;
import com.example.dao.MenuMapper;
import com.example.entity.Menu;
import com.example.entity.MsTree;
import com.example.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
@Service
public class MenuBizImpl implements MenuBiz {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public String selectPermsByMenuId(Integer menuId) {
        return menuMapper.selectPermsByMenuId(menuId);
    }

    //查询所有的菜单，组装成tree格式
    @Override
    public List<MsTree> selectAllMenu() {
        //查询所有的菜单
        List<Menu> menuList = menuMapper.selectAllMenu();
        //组装成tree格式
        return TreeUtils.getChildPerms(menuList, 0);
    }

    //根据用户登录名查询对应的所有菜单
    @Override
    public List<MsTree> selectMenuByUserLoginName(String loginName) {
        //根据用户loginName查询所有的菜单
        List<Menu> menuList = menuMapper.selectMenuByUserLoginName(loginName);
        //组装成tree格式
        return TreeUtils.getChildPerms(menuList, 0);
    }

    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAllMenu();
    }

    @Override
    public Object insert(Menu record) {
        int i = menuMapper.insert(record);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    @Override
    public int delMenuByID(List<Integer> ids) {
        return menuMapper.delMenuByID(ids);
    }

    @Override
    public Object deleteByPrimaryKey(Integer menuId) {
        int i = menuMapper.deleteByPrimaryKey(menuId);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

    @Override
    public Object updateByPrimaryKey(Menu record) {
        int i = menuMapper.updateByPrimaryKey(record);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code",MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }
}
