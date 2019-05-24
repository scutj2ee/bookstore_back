package com.scutj2ee.bookstore.utils.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:13
 * @ Description：Base64工具
 * @ Modified By：
 */
public class Base64ConvertUtil {
    /**
     * create by: Bin Liu
     * description: 加密JDK1.8
     * create time: 2019/5/24 9:16
     * @Param: null
     * @return 
     */
    public static String encode(String str) throws UnsupportedEncodingException {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
        return new String(encodeBytes);
    }
    
    /**
     * create by: Bin Liu
     * description: 解密JDK1.8
     * create time: 2019/5/24 9:18
     * @Param: null
     * @return 
     */
    public static String decode(String str) throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
        return new String(decodeBytes);
    }
}
