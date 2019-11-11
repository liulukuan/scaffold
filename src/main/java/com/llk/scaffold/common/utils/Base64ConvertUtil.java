package com.llk.scaffold.common.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @className: Base64ConvertUtil
 * @description: Base64工具
 * @author: LiuLukuan
 * @date: 2019/11/10 23:09
 */
public class Base64ConvertUtil {

    /**
     * 加密
     *
     * @param str 字符串
     * @return 加密字符串
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    public static String encode(String str) throws UnsupportedEncodingException {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8));
        return new String(encodeBytes);
    }

    /**
     * 解密
     *
     * @param str 加密字符串
     * @return 解密后的字符串
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    public static String decode(String str) throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8));
        return new String(decodeBytes);
    }
}
