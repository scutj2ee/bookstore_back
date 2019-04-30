package com.scutj2ee.bookstore.utils;

import com.scutj2ee.bookstore.entity.Address;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:23
 * @ Description：${description}
 * @ Modified By：
 */
public class RandomUtil {
    /**
     * create by: Bin Liu
     * description: 时间 + 五位随机数
     * create time: 2019/4/30 10:23
     * @Param: null
     * @return
     */
    public static String getRandomFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = format.format(date);
        Random random = new Random();
        /** 获取五位随机数 */
        int rannum = (int)(random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        return rannum + str;
    }

    /**
     * create by: Bin Liu
     * description: 六位随机数（注册邮箱验证码）
     * create time: 2019/4/30 10:25
     * @Param: null
     * @return
     */
    public static String getRandomVerCode() {
        return  String.valueOf(new Random().nextInt(899999) + 100000);
    }

    /**
     * create by: Bin Liu
     * description: UUID方式
     * create time: 2019/4/30 10:24
     * @Param: null
     * @return
     */
    public static String getRandomOrderId() {
        //随机生成一位整数
        int random = (int)(Math.random() * 9 + 1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if (hashCode < 0) {
            hashCode = - hashCode;
        }
        String value = "TYBX" + valueOf + String.format("%010d",hashCode);
        return value;
    }

    public static String generaterNumberOfSix(){
        return String.valueOf((int)((Math.random()*9 + 1) * 100000));
    }
}
