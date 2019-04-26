package com.scutj2ee.bookstore.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/26 19:37
 * @ Description：shiro配置
 * @ Modified By：
 */
public class ShiroConfig {
    private final static Logger logger=LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * create by: Bin Liu
     * description: ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
     * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager
     * create time: 2019/4/26 20:15
     * @Param: null
     * @return 
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("security") SecurityManager manager){


    }

}
