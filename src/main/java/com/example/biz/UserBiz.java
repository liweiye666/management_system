package com.example.biz;

import com.example.entity.User;

import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.biz
 * @Author: 周博义
 * @Date: Created in 2020/5/28 23:41
 */
public interface UserBiz {

    User selectByPrimaryKey(Integer userId);

    User selectByLoginName(String loginName);
}
