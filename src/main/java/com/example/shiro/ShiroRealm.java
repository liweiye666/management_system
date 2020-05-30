package com.example.shiro;

import com.example.biz.MenuBiz;
import com.example.biz.RoleMenuBiz;
import com.example.biz.UserBiz;
import com.example.biz.UserRoleBiz;
import com.example.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

    @Autowired
    private UserRoleBiz userRoleBizImpl;

    @Autowired
    private RoleMenuBiz roleMenuBizImpl;

    @Autowired
    private MenuBiz menuBizImpl;

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
        int roleId = userRoleBizImpl.selectRoleIdByUserId(user.getUserId());//从数据库中获取角色ID
        List<Integer> menuIdList = roleMenuBizImpl.selectMenuIdByRoleId(roleId);//从数据库中获取菜单ID
        List<String> permsList = new ArrayList<>();
        for (int menuId : menuIdList) {
            permsList.add(menuBizImpl.selectPermsByMenuId(menuId));//将每个菜单ID对应的权限字符串从数据库中搜索出来
        }
        for (String perms : permsList) {
            simpleAuthorizationInfo.addStringPermission(perms);//将所有权限字符串添加到用户权限中
        }
        return simpleAuthorizationInfo;
    }

    /**
     * shiro安全框架的认证
     * @param authenticationToken
     * @return AuthenticationInfo 返回为null时说明认证失败
     * @throws AuthenticationException
     * @Return AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //取出令牌信息
        UsernamePasswordToken usernamePasswordToken =
                (UsernamePasswordToken) authenticationToken;

        //登录认证分两个步骤，步骤一：查询用户是否存在
        String loginName = usernamePasswordToken.getUsername();
        User user = userBizImpl.selectByLoginName(loginName);
        if (user == null) {
            return null;
        }

        //从数据库中获取密码和盐
        String password = user.getPassword();
        String salt = user.getSalt();
        ByteSource byteSource = ByteSource.Util.bytes(salt);

        //创建简单的shiro认证消息对象
        SimpleAuthenticationInfo simpleAuthenticationInfo;

        //步骤二：判断是否为管理员
        if (userRoleBizImpl.selectRoleIdByUserId(user.getUserId()) == 1) {
            //步骤三：查询密码是否正确，管理员验证密码不需要盐
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, getName());
        } else {
            //步骤三：查询密码是否正确
            /**
             * Object principal 实体，例如这里就是User对象
             * Object credentials 数据库中的密码
             * ByteSource credentialsSalt 创建密码密文时加密用的盐(从数据库中获取)
             * String realmName 当前realm的name，用getRealm()方法获取，getRealm()方法在这个类的曾祖父类中，已被继承
             */
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, byteSource, getName());
        }
        return simpleAuthenticationInfo;
    }
}
