package com.scutj2ee.bookstore.utils.common;

import com.scutj2ee.bookstore.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:21
 * @ Description： Serializable工具(JDK)
 * @ Modified By：
 */
public class SerializableUtil {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SerializableUtil.class);

    /**
     * 序列化
     * @param object
     * @return byte[]
     * @author Wang926454
     * @date 2018/9/4 15:14
     */
    public static byte[] serializable(Object object) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (IOException e) {
            LOGGER.error("SerializableUtil工具类序列化出现IOException异常:" + e.getMessage());
            throw new CustomException("SerializableUtil工具类序列化出现IOException异常:" + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                LOGGER.error("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
                throw new CustomException("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
            }
        }
    }

    /**
     * 反序列化
     * @param bytes
     * @return java.lang.Object
     * @author Wang926454
     * @date 2018/9/4 15:14
     */
    public static Object unserializable(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (ClassNotFoundException e) {
            LOGGER.error("SerializableUtil工具类反序列化出现ClassNotFoundException异常:" + e.getMessage());
            throw new CustomException("SerializableUtil工具类反序列化出现ClassNotFoundException异常:" + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
            throw new CustomException("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                LOGGER.error("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
                throw new CustomException("SerializableUtil工具类反序列化出现IOException异常:" + e.getMessage());
            }
        }
    }
}
