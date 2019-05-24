package com.scutj2ee.bookstore.config.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/23 16:57
 * @ Description：JwtToken
 * @ Modified By：
 */
public class JwtToken implements AuthenticationToken {
    /**
     * Token
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
