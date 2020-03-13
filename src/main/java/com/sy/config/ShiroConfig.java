package com.sy.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //设置shiro 过滤   anon 无需认证， authc 必须认证
        //这个地方过滤的是 请求路径
        filterChainDefinitionMap.put("/mall/to*", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //设置首页
        bean.setLoginUrl("/mall/toLogin");
        return bean;   //之后要加密码验证 无权页面 记住我
    }

    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
        SecurityManager.setRealm(userRealm);

        return SecurityManager;
    }

    //把UserRealm注册到spring 可以取别名，方便其他调用
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
