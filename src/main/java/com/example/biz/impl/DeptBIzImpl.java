package com.example.biz.impl;

import com.example.biz.DeptBiz;
import com.example.dao.DeptMapper;
import com.example.entity.Dept;
import com.example.util.MyConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: management_system
 * @Package: com.example.biz.impl
 * @Author: 利伟业
 * @Date: 2020/5/29 17:06
 */
@Service
public class DeptBIzImpl implements DeptBiz {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public PageInfo<Dept> selectAllDept(int page, int limit) {
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        List<Dept> myUserInfos = deptMapper.selectAllDept();
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Dept> pageInfo = new PageInfo(myUserInfos);
        return pageInfo;
    }

    @Override
    public Object insert(Dept record) {
        int i = deptMapper.insert(record);
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
    public Object deleteByPrimaryKey(Integer deptId) {
        int i = deptMapper.deleteByPrimaryKey(deptId);
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
    public int delDeptByID(List<Integer> ids) {
        return deptMapper.delDeptByID(ids);
    }

    @Override
    public Object updateByPrimaryKey(Dept record) {
        int i = deptMapper.updateByPrimaryKey(record);
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
