package com.example.shiro;

import com.example.biz.UserBiz;
import com.example.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.shiro
 * @Author: 周博义
 * @Date: Created in 2020/5/29 11:31
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserBiz userBizImpl;

    /**
     * shiro安全框架的授权
     * @param principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始");

        SimpleAuthorizationInfo simpleAuthorizationInfo =
                new SimpleAuthorizationInfo();

        //获取用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //权限字符串从数据库中获取
        String perms = user.getAvatar();
        String perms2 = user.getEmail();
        simpleAuthorizationInfo.addStringPermission(perms);
        simpleAuthorizationInfo.addStringPermission(perms2);
        return simpleAuthorizationInfo;
    }

    /**
     * shiro安全框架的认证
     * @param authenticationToken
     * @return AuthenticationInfo 返回为null时说明认证失败
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证开始");

        //取出令牌信息
        UsernamePasswordToken usernamePasswordToken =
                (UsernamePasswordToken) authenticationToken;

        //登录认证分两个步骤，步骤一：查询用户是否存在
        String loginName = usernamePasswordToken.getUsername();
        User user = userBizImpl.selectByLoginName(loginName);
        if (user == null) {
            return null;
        }

        //步骤二：查询密码是否正确
        String password = user.getPassword();
        String salt = user.getSalt();
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        /**
         * @param principal 实体，例如这里就是User对象
         * @param credentials 数据库中的密码
         * @param credentialsSalt 创建密码密文时加密用的盐(从数据库中获取)
         * @param realmName 当前realm的name，用getRealm()方法获取，getRealm()方法在这个类的曾祖父类中，已被继承
         */
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user, password, byteSource, getName());
        return simpleAuthenticationInfo;
    }
}
