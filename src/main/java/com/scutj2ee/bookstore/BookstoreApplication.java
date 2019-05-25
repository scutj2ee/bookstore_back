package com.scutj2ee.bookstore;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;


@MapperScan("com.scutj2ee.bookstore.dao")
@SpringBootApplication
public class BookstoreApplication extends SpringBootServletInitializer {
    @Autowired
    private MultipartConfigElement multipartConfigElement;
    
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BookstoreApplication.class);
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean reg = new ServletRegistrationBean(dispatcherServlet);
        reg.getUrlMappings().clear();
        reg.setLoadOnStartup(1);
        //只拦截.do操作
        reg.addUrlMappings("*.do");
        reg.setMultipartConfig(multipartConfigElement);
        return reg;
    }
}
