package com.example.biz;

import com.example.entity.Dept;
import com.example.entity.Menu;
import com.example.entity.MsTree;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/29 17:18
 */
public interface MenuBiz {

    String selectPermsByMenuId(Integer menuId);

    List<MsTree> selectAllMenu();

    List<MsTree> selectMenuByUserLoginName(String loginName);

    List<Menu> selectAll();

    Object insert(Menu record);
}
