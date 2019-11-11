package com.llk.scaffold.common.config.shiro;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @className: JwtToken
 * @description:
 * @author: LiuLukuan
 * @date: 2019/11/11 0:03
 */
@AllArgsConstructor
public class JwtToken implements AuthenticationToken {
    /**
     * Token
     */
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
