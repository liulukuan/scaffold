package com.llk.scaffold.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 * @className: JwtUtil
 * @description: JAVA-JWT工具类
 * @author: LiuLukuan
 * @date: 2019/11/10 23:09
 */
@Slf4j
@Component
public class JwtUtil {

    /**
     * JWT-account
     */
    public final static String ACCOUNT = "account";

    /**
     * JWT-currentTimeMillis
     */
    public final static String CURRENT_TIME_MILLIS = "currentTimeMillis";

    /**
     * JWT认证加密私钥(Base64加密)
     */
    public final static String ENCRYPY_JWT_KEY = "U0JBUElKV1RkV2FuZzkyNjQ1NA==";

    /**
     * token 过期时间（毫秒），这里设置 1 小时
     */
    public final static Long ACCESS_TOKEN_EXPIRE_TIME = 3600000L;

    /**
     * token 过期时间（秒），这里设置 5 小时 refreshTokenExpireTime
     */
    public final static Integer REFRESH_TOKEN_EXPIRE_TIME = 18000;

    /**
     * 校验token是否正确
     *
     * @param token Token
     * @return boolean 是否正确
     * @author Wang926454
     * @date 2018/8/31 9:05
     */
    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, ACCOUNT) + Base64ConvertUtil.decode(ENCRYPY_JWT_KEY);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            log.error("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new RuntimeException("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }

    /**
     * token 是否过期
     *
     * @return true：过期
     */
    public static boolean isTokenExpired(String token) {
        try {
            Date now = Calendar.getInstance().getTime();
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt().before(now);
        } catch (JWTDecodeException e) {
            log.error("判断Token是否过期出现JWTDecodeException异常:" + e.getMessage());
            throw new RuntimeException("判断Token是否过期出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    /**
     * 获取过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpiresAt(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();
        }catch(JWTDecodeException e){
            log.error("获取Token的过期时间出现JWTDecodeException异常:" + e.getMessage());
            throw new RuntimeException("获取Token的过期时间出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    /**
     * 获得Token中的信息无需secret解密也能获得
     *
     * @param token
     * @param claim
     * @return
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            log.error("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
            throw new RuntimeException("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    /**
     * 生成签名
     *
     * @param account 帐号
     * @return 返回加密的Token
     */
    public static String sign(String account, String currentTimeMillis) {
        try {
            // 帐号加JWT私钥加密
            String secret = account + Base64ConvertUtil.decode(ENCRYPY_JWT_KEY);
            // 此处过期时间是以毫秒为单位
            Date date = new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带account帐号信息
            return JWT.create()
                    .withClaim(ACCOUNT, account)
                    .withClaim(CURRENT_TIME_MILLIS, currentTimeMillis)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new RuntimeException("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }
}
