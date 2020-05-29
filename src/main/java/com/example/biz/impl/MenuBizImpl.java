package com.example.biz.impl;

import com.example.biz.MenuBiz;
import com.example.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
