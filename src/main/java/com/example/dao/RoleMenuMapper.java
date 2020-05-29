package com.example.dao;

import com.example.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMenuMapper {
    int deleteByPrimaryKey(RoleMenu key);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<Integer> selectMenuIdByRoleId(Integer roleId);
}