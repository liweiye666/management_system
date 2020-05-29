package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}