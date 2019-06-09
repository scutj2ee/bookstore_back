package com.scutj2ee.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/8 22:14
 * @ Description：FastDFS配置类
 * @ Modified By：
 */
@Component
public class FastDFSConfig {
    @Value("${fdfs.resHost}")
    private String resHost;

    @Value("${fdfs.storagePort}")
    private String storagePort;

    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }
}
