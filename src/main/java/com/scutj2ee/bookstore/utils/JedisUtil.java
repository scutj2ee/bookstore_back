package com.scutj2ee.bookstore.utils;

import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.utils.common.SerializableUtil;
import com.scutj2ee.bookstore.utils.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:58
 * @ Description：JedisUtil(推荐存Byte数组，存Json字符串效率更慢)
 * @ Modified By：
 */
public class JedisUtil {
    /**
     * 静态注入JedisPool连接池
     * 本来是正常注入JedisUtil，可以在Controller和Service层使用，但是重写Shiro的CustomCache无法注入JedisUtil
     * 现在改为静态注入JedisPool连接池，JedisUtil直接调用静态方法即可
     * https://blog.csdn.net/W_Z_W_888/article/details/79979103
     */
    private static JedisPool jedisPool;

    @Autowired
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
    }

    /**
     * create by: Bin Liu
     * description: 获取Jedis实例
     * create time: 2019/5/24 10:07
     * @Param: null
     * @return 
     */
    public static synchronized Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new CustomException("获取Jedis资源异常:" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 释放Jedis资源
     * create time: 2019/5/24 10:07
     * @Param: null
     * @return 
     */
    public static void closePool() {
        try {
            jedisPool.close();
        } catch (Exception e) {
            throw new CustomException("释放Jedis资源异常:" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 获取redis键值-object
     * create time: 2019/5/24 10:13
     * @Param: null
     * @return 
     */
    public static Object getObject(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] bytes = jedis.get(key.getBytes());
            if (StringUtil.isNotNull(bytes)) {
                return SerializableUtil.unserializable(bytes);
            }
        } catch (Exception e) {
            throw new CustomException("获取Redis键值getObject方法异常:key=" + key + " cause=" + e.getMessage());
        }
        return null;
    }

    /**
     * create by: Bin Liu
     * description: 设置redis键值-object
     * create time: 2019/5/24 10:14
     * @Param: null
     * @return 
     */
    public static String setObject(String key, Object value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key.getBytes(), SerializableUtil.serializable(value));
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setObject方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 设置redis键值-object-expiretime
     * create time: 2019/5/24 10:15
     * @Param: null
     * @return 
     */
    public static String setObject(String key, Object value, int expiretime) {
        String result;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key.getBytes(), SerializableUtil.serializable(value));
            if (Constant.OK.equals(result)) {
                jedis.expire(key.getBytes(), expiretime);
            }
            return result;
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setObject方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 获取redis键值-Json
     * create time: 2019/5/24 10:17
     * @Param: null
     * @return 
     */
    public static String getJson(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            throw new CustomException("获取Redis键值getJson方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 设置redis键值-Json
     * create time: 2019/5/24 10:18
     * @Param: null
     * @return 
     */
    public static String setJson(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setJson方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 设置redis键值-Json-expiretime
     * create time: 2019/5/24 10:18
     * @Param: null
     * @return 
     */
    public static String setJson(String key, String value, int expiretime) {
        String result;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.set(key, value);
            if (Constant.OK.equals(result)) {
                jedis.expire(key, expiretime);
            }
            return result;
        } catch (Exception e) {
            throw new CustomException("设置Redis键值setJson方法异常:key=" + key + " value=" + value + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 删除key
     * create time: 2019/5/24 10:19
     * @Param: null
     * @return 
     */
    public static Long delKey(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("删除Redis的键delKey方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: key是否存在
     * create time: 2019/5/24 10:19
     * @Param: null
     * @return
     */
    public static Boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("查询Redis的键是否存在exists方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
     * create time: 2019/5/24 10:20
     * @Param: null
     * @return
     */
    public static Set<String> keysS(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.keys(key);
        } catch (Exception e) {
            throw new CustomException("模糊查询Redis的键集合keysS方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 模糊查询获取key集合(keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用)
     * create time: 2019/5/24 10:20
     * @Param: null
     * @return
     */
    public static Set<byte[]> keysB(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.keys(key.getBytes());
        } catch (Exception e) {
            throw new CustomException("模糊查询Redis的键集合keysB方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }

    /**
     * create by: Bin Liu
     * description: 获取过期剩余时间
     * create time: 2019/5/24 10:22
     * @Param: null
     * @return
     */
    public static Long ttl(String key) {
        Long result = -2L;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.ttl(key);
            return result;
        } catch (Exception e) {
            throw new CustomException("获取Redis键过期剩余时间ttl方法异常:key=" + key + " cause=" + e.getMessage());
        }
    }
}
