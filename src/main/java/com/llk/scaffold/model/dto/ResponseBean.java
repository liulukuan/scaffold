package com.llk.scaffold.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: ResponseBean
 * @description: 响应实体类
 * @author: LiuLukuan
 * @date: 2019/11/11 0:23
 */
@Data
@AllArgsConstructor
public class ResponseBean {

    /**
     * HTTP状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private Object data;
}
