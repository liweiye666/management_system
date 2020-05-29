package com.example.dao;

import com.example.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    Integer selectRoleIdByUserId(Integer userId);
}