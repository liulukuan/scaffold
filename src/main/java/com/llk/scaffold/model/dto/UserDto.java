package com.llk.scaffold.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.llk.scaffold.model.entity.User;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import java.util.Date;

/**
 * @author dolyw.com
 * @date 2018/8/30 10:34
 */
@Data
public class UserDto extends User {
    /**
     * 登录时间
     */
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;
}
