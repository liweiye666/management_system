package com.example.shiro;

import com.example.util.MyConstants;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project: management_system
 * @Package: com.example.shiro
 * @Author: 周博义
 * @Date: Created in 2020/5/30 10:16
 */
@Configuration
public class ShiroConfig {

    /**
     * realm
     * 定义一个bean，id为方法名
     * <bean id="" class=""></bean>
     * @return
     */
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        return shiroRealm;
    }

    /**
     * securityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm());
        return defaultWebSecurityManager;
    }

    /**
     * shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        /**
         * 认证过滤器：
         * anon: 无需认证
         * authc: 必须认证才能到达
         * user: 使用remember me（一周内免登录）的时候使用
         * perms: 访问的资源需要某个权限才能到达
         * roles: 访问的资源需要某个角色才能到达
         */
        //LinkedHashMap是一个有序的HashMap，是一个链条
        Map<String, String> map = new LinkedHashMap<>();
        //放行的页面请求
        map.put("/toLogin", "anon");
        map.put("/login", "anon");
        //添加到达页面需要的权限
        //User相关
        map.put("/toUser", "perms[/systemUserView]");
        map.put("/user/selectAllUser", "perms[/systemUserSelect]");
        map.put("/user/insertUser", "perms[/systemUserInsert]");
        map.put("/user/updateUser", "perms[/systemUserUpdate]");
        map.put("/user/deleteUser", "perms[/systemUserDelete]");
        map.put("/user/selectByLoginName", "perms[/systemUserSelect]");
        //Role相关
        map.put("/toRole", "perms[/systemRoleView]");
        map.put("/role/selectAll", "perms[/systemRoleSelect]");
        map.put("/role/addRole", "perms[/systemRoleInsert]");
        map.put("/role/delRole", "perms[/systemRoleDelete]");
        map.put("/role/editRole", "perms[/systemRoleUpdate]");
        map.put("/role/deleteRole", "perms[/systemRoleDelete]");
        //菜单相关
        map.put("/toMenu", "perms[/systemMenuView]");
        map.put("/menu/selectAllMenu", "perms[/systemMenuSelect]");
        map.put("/menu/selectAll", "perms[/systemMenuSelect]");
        map.put("/menu/addMenu", "perms[/systemMenuInsert]");
        map.put("/menu/delMenu", "perms[/systemMenuDelete]");
        map.put("/menu/deleteMenu", "perms[/systemMenuDelete]");
        map.put("/menu/editMenu", "perms[/systemMenuUpdate]");
        //部门相关
        map.put("/toDept", "perms[/systemDeptView]");
        map.put("/dept/selectAll", "perms[/systemDeptSelect]");
        map.put("/dept/addDept", "perms[/systemDeptInsert]");
        map.put("/dept/deleteDept", "perms[/systemDeptDelete]");
        map.put("/dept/delDept", "perms[/systemDeptDelete]");
        map.put("/dept/editDept", "perms[/systemDeptUpdate]");
        //过滤的页面请求(需要授权)
        map.put("/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //修改默认登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //指定未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnau");
        return shiroFilterFactoryBean;
    }

    /**
     * 实例化密码比较器
     */
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher =
                new HashedCredentialsMatcher();
        //使用MD5加密
        credentialsMatcher.setHashAlgorithmName(MyConstants.algorithmName);
        //加密1000次
        credentialsMatcher.setHashIterations(MyConstants.hashIterations);
        return credentialsMatcher;
    }
}
