package com.scutj2ee.bookstore.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/26 19:16
 * @ Description：文件上传配置
 * @ Modified By：
 */
@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }
}
