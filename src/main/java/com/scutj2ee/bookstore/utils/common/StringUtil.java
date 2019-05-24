package com.scutj2ee.bookstore.utils.common;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:25
 * @ Description：String工具
 * @ Modified By：
 */
public class StringUtil {
    /**
     * 定义下划线
     */
    private static final char UNDERLINE = '_';

    /**
     * create by: Bin Liu
     * description: String为空判断(不允许空格)
     * create time: 2019/5/24 9:26
     * @Param: null
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * create by: Bin Liu
     * description: String不为空判断(不允许空格)
     * create time: 2019/5/24 9:26
     * @Param: null
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * create by: Bin Liu
     * description: Byte数组为空判断
     * create time: 2019/5/24 9:26
     * @Param: null
     * @return
     */
    public static boolean isNull(byte[] bytes) {
        // 根据byte数组长度为0判断
        return bytes == null || bytes.length == 0;
    }

    /**
     * create by: Bin Liu
     * description: Byte数组不为空判断
     * create time: 2019/5/24 9:26
     * @Param: null
     * @return
     */
    public static boolean isNotNull(byte[] bytes) {
        return !isNull(bytes);
    }

    /**
     * create by: Bin Liu
     * description: 驼峰转下划线工具
     * create time: 2019/5/24 9:26
     * @Param: null
     * @return
     */
    public static String camelToUnderline(String param) {
        if (isNotBlank(param)) {
            int len = param.length();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = param.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(UNDERLINE);
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * create by: Bin Liu
     * description: 下划线转驼峰工具
     * create time: 2019/5/24 9:28
     * @Param: null
     * @return
     */
    public static String underlineToCamel(String param) {
        if (isNotBlank(param)) {
            int len = param.length();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = param.charAt(i);
                if (c == 95) {
                    ++i;
                    if (i < len) {
                        sb.append(Character.toUpperCase(param.charAt(i)));
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * create by: Bin Liu
     * description: 在字符串两周添加''
     * create time: 2019/5/24 9:30
     * @Param: null
     * @return
     */
    public static String addSingleQuotes(String param) {
        return "\'" + param + "\'";
    }

}
