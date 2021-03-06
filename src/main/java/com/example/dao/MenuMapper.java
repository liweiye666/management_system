package com.example.dao;

import com.example.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    String selectPermsByMenuId(Integer menuId);

    List<Menu> selectAllMenu();

    List<Menu> selectMenuByUserLoginName(String loginName);

    int delMenuByID( @Param("ids") List<Integer> ids);
}