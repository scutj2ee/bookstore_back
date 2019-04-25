package com.scutj2ee.bookstore.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.security.MessageDigest;

/**
 * @Author kobe
 * @Date 2019/4/25 15:30
 * @Description: 文件照片上传工具类
 * @Modified By:
 */
public class FileUtil {
    /**
     * create by: Kobe
     * description:
     * create time: 15:43 2019/4/25
     * @param
     * @return
     */
    public static String saveFile(MultipartFile file) throws Exception{
        if(file == null || file.isEmpty()){
            return "";
        }

        File target = new File("file");
        if(!target.isDirectory()){
            target.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(file.getBytes());

    }
}
