package com.scutj2ee.bookstore.utils.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:18
 * @ Description：Json和Object的互相转换，转List必须Json最外层加[]，转Object，Json最外层不要加[]
 * @ Modified By：
 */
public class JsonConvertUtil {
    /**
     * JSON 转 Object
     */
    public static <T> T jsonToObject(String pojo, Class<T> clazz) {
        return JSONObject.parseObject(pojo, clazz);
    }

    /**
     * Object 转 JSON
     */
    public static <T> String objectToJson(T t){
        return JSONObject.toJSONString(t);
    }
}
