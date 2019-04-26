package com.scutj2ee.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/26 19:12
 * @ Description：允许前端跨域请求配置
 * @ Modified By：
 */
@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                //使session统一
                .allowCredentials(true);
    }

    //其中一种方式
    /*private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //设置访问源地址
        corsConfiguration.addAllowedHeader("*"); //设置访问源请求头
        corsConfiguration.addAllowedMethod("*"); //设置访问源请求方法
        return corsConfiguration;
    }

    @Bean
    public CorsFilter crosFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }*/
}
