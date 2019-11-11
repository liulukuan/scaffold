package com.llk.scaffold.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @className: JsonConvertUtil
 * @description: Json和Object的互相转换，转List必须Json最外层加[]，转Object，Json最外层不要加[]
 * @author: LiuLukuan
 * @date: 2019/11/11 0:06
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
