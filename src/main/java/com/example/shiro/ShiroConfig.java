package com.example.shiro;

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
        map.put("/toRole", "perms[system:role:view]");
        //过滤的页面请求(需要授权)
        map.put("/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //修改默认登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //指定未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnau");
        return shiroFilterFactoryBean;
    }
}
