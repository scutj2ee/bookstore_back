package com.scutj2ee.bookstore.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/3 9:27
 * @ Description：基础阿里支付宝支付配置类
 * @ Modified By：
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
    应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    */
    public static String app_id = "填写 APPID ";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBVjx5WDUGhA4bPKCCJLZeRU68eVoBYB7kme0fytrmh9F842jvYhWfwxHqwagjlk68dzHLb1YsdxIs3Boeic3MCrBVAg+6SRCG2unhaX4yrFNYw8bAM8604o6oM5m5fNQx54ylOimSmuy1WtKazrbSkQ6WZ6+U4Pam1UaVxwdVDv0XczW7zLR4Du8kD97QN+zB9oj9v3Q464iwDl6G0LQajpNVNlgzQFFNic8mWGaN7JomO7SgwH8dbm8/S485dbNdaLOrCVfHyKfTNgon94NsTE34YBkCMB43cM5tVDL0LT+Dlqnmzvvvaac9Ei1BwmWFV9rS0bBZXj2BMOv4eFtZAgMBAAECggEAWtqOLpt03DflhOKIygMqDHzZO3JvdGnmKaWrOdsQ/EHKOdWxv/8Bu7GXI3aYOy957dA5LXPvb9rQ7KxMuMkKxNt5VK3XCIAM2P5srsihOs1s2vzj395ExTIlDij5QqBamxfR57s8utyTjS3YpaCyMqZtPeBmKcoB2d4V8F7YWrnlqdOFiMSC6s08xFQ2615VHeHfQGFlX/zFFJh6JNnF6x4aNCXy9q4CdnPuptXba3ZL5hkjLs8rKy0xT4t2o0Nl5fLHEb7aITT4Qma3Ni/jrvTZ249S0WdvhUedm/mj4hotDIG/XF3EdB3eJ6bV8+QV3/jF8kJbBdxiDtAOrIaSEQKBgQDAdg4594tNtj61NAfLnI4crp54EMk8udy/wLwgwksY31iECtvJILhPWOWrMlLjarFFQkHXAtZJwPii8UC96gvh4bTBVtaG4ZUeGP1o9HmQGukkcZc3b6gdWRVf4WrPfM5kEoo4jaDo7/z39oz5crumTJob9v5yltJZelJKABPBDQKBgQCsCTOQKLczs7/YxYZ7AEC6jHlJBs31Voe96VLcJwwxwXVjpq751c7fe2R6/zCzffk8DdZNnEzg3/bVGnkhcpcmCbh3poDmkx4gZMwUntjf+n9sRoBgyBAqCU6+KXfqsaQo8BoEbIInVvARHpPaARKl9Auzu0ETVIwO2Vq09ml4fQKBgHB8j5QRurmQ6tW9s1CuD+Fzres+5F85wmvQmiQLaxj+cR27uvmyxgaaTqHgp9GDaliwgQrJ/bTdtHSHzO8y+/7pjFv0BS6QajdNI89UFDjFgb5rJZahDAEbMAL6HRNoPrj+nQqwvHtoyNGkqICjLknkO65cjhsrS4ZAmBfoM6OBAoGAJXWDcrpK2ckj1tF7rMCrV3NK3WnL4sXKnMF3N1SRRSw4oVAj/WZeuy6k/FsggZTGdhsVNKT54GUj29b91RicbL3lGrh4jLwv7SHFhh/oXSywHiVjwq8NRfns2V8yKzou4nMVVy1BUcuOTkv4KZneM6BmA+acDtdz/6+4HnshEAkCgYBqi2yPMl0fmhfwQK3pYd6koSP2F/lzHAjH/iWcZKEisVb0ZSxD8s18bEJpWoMn6oRPPeF5Zdl9thlgYDX3qOza7TZpMdzqx+PldUWgOzWmL5SluQHdRdnPiIAwnhAUzvlXCchkwtsAGmVeYDWjljm4iVcSN9tmmX5VTu+wAsBRNg==";

    /**
     *  支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgVY8eVg1BoQOGzyggiS2XkVOvHlaAWAe5JntH8ra5ofRfONo72IVn8MR6sGoI5ZOvHcxy29WLHcSLNwaHonNzAqwVQIPukkQhtrp4Wl+MqxTWMPGwDPOtOKOqDOZuXzUMeeMpTopkprstVrSms620pEOlmevlOD2ptVGlccHVQ79F3M1u8y0eA7vJA/e0DfswfaI/b90OOuIsA5ehtC0Go6TVTZYM0BRTYnPJlhmjeyaJju0oMB/HW5vP0uPOXWzXWizqwlXx8in0zYKJ/eDbExN+GAZAjAeN3DObVQy9C0/g5ap5s7772mnPRItQcJlhVfa0tGwWV49gTDr+HhbWQIDAQAB";

     /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     * public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
     * 这里根据你项目中的controller进行配置
     */
    public static String notify_url = "http://localhost:8080/alipay/notify";

    /**
    * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    * public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    * 这里根据你项目中的controller进行配置
    */
    public static String return_url = "http://localhost:8080/alipay/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    /**支付宝网关
    * public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";//项目正式使用后使用
    * 使用沙箱环境时使用
    */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "F:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
