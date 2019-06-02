package com.scutj2ee.bookstore.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;

/**
 * @Author kobe
 * @Date 2019/4/25 15:30
 * @Description: 文件照片上传工具类
 * @Modified By: Liu Bin
 */
public class FileUploadUtil {
    /**
     * create by: Bin Liu
     * description: 保存上传的文件
     * create time: 2019/6/2 19:43
     * @Param: null
     * @return
     */
    public static String saveFile(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty())
            return "";
        File target = new File("file");
        if (!target.isDirectory()) {
            target.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(file.getBytes());
        String fileName = (Helper.bytesToHex(md.digest(),0,md.digest().length-1)) + "." + getPostfix(originalFilename);
        File file1 = new File(target.getPath() + "/" + fileName);
        Files.write(Paths.get(file1.toURI()), file.getBytes(), StandardOpenOption.CREATE_NEW);
        return "/bookstore/book/img/" + fileName;
    }

    /**
     * create by: Bin Liu
     * description: 获得文件的后缀名
     * create time: 2019/6/2 19:47
     * @Param: null
     * @return 
     */
    public static String getPostfix(String fileName) {
        if (fileName == null || "".equals(fileName.trim())) {
            return "";
        }
        if (fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        }
        return "";
    }
}