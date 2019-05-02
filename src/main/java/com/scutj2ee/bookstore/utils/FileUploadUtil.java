package com.scutj2ee.bookstore.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author kobe
 * @Date 2019/4/25 15:30
 * @Description: 文件照片上传工具类
 * @Modified By: Liu Bin
 */
public class FileUploadUtil {
    /**
     * create by: Kobe
     * description:
     * create time: 15:43 2019/4/25
     *
     * @param
     * @return
     */
    public static String saveFile(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            return "";
        }

        File target = new File("file");
        if (!target.isDirectory()) {
            target.mkdirs();
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //加个时间戳，尽量避免文件名称重复
        String newFileName = sdf.format(new Date()) + "_" + fileName;
        String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +  newFileName;
        File dest = new File(path);
        //判断文件是否已经存在
        if (dest.exists()) {
            return "";
        }
        //上传文件(保存文件)
        file.transferTo(dest);
        String url = "localhost:8080/img/" + newFileName;

        return url;
    }
}