package com.scutj2ee.bookstore.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:16
 * @ Description：获取前端传递参数的工具类
 * @ Modified By：
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String name) {

        try {
            return Integer.decode(request.getParameter(name));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String name) {

        try {
            return Long.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request, String name) {

        try {
            return Double.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static Boolean getBoolean(HttpServletRequest request, String name) {

        try {
            return Boolean.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String name) {
        try {
            String result = request.getParameter(name);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result))
                result = null;
            return result;
        } catch (Exception e) {
            return null;
        }

    }
}
