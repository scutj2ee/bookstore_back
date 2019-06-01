/*
package com.scutj2ee.bookstore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.utils.common.Base64ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

*/
/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:39
 * @ Description：JAVA-JWT工具类
 * @ Modified By：
 *//*

@Component
public class JwtUtil {
    */
/**
     * LOGGER
     *//*

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    */
/**
     * 过期时间改为从配置文件获取
     *//*

    private static String accessTokenExpireTime;

    */
/**
     * JWT认证加密私钥(Base64加密)
     *//*

    private static String encryptJWTKey;

    @Value("${accessTokenExpireTime}")
    public void setAccessTokenExpireTime(String accessTokenExpireTime) {
        JwtUtil.accessTokenExpireTime = accessTokenExpireTime;
    }

    @Value("${encryptJWTKey}")
    public void setEncryptJWTKey(String encryptJWTKey) {
        JwtUtil.encryptJWTKey = encryptJWTKey;
    }

    */
/**
     * create by: Bin Liu
     * description: 校验token是否正确
     * create time: 2019/5/24 9:41
     * @Param: null
     * @return 
     *//*

    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, Constant.USERNAME) + Base64ConvertUtil.decode(encryptJWTKey);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new CustomException("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }

    */
/**
     * create by: Bin Liu
     * description: 获得Token中的信息无需secret解密也能获得
     * create time: 2019/5/24 9:45
     * @Param: null
     * @return 
     *//*

    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            LOGGER.error("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
            throw new CustomException("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    */
/**
     * create by: Bin Liu
     * description: 生成签名
     * create time: 2019/5/24 9:45
     * @Param: null
     * @return 
     *//*

    public static String sign(String username, String currentTimeMillis) {
        try {
            // 帐号加JWT私钥加密
            String secret = username + Base64ConvertUtil.decode(encryptJWTKey);
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Date date = new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpireTime) * 1000);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username帐号信息
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("currentTimeMillis", currentTimeMillis)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new CustomException("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }
}
*/
