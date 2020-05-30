package com.example.biz;

import com.example.entity.Dept;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeptBiz {
    PageInfo<Dept> selectAllDept(int page, int limit);
    Object insert(Dept record);
    Object deleteByPrimaryKey(Integer deptId);
    int delDeptByID( @Param("ids") List<Integer> ids);
    Object updateByPrimaryKey(Dept record);
}
