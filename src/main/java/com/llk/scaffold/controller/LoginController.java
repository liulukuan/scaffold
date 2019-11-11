package com.llk.scaffold.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.llk.scaffold.common.utils.AesCipherUtil;
import com.llk.scaffold.common.utils.JwtUtil;
import com.llk.scaffold.common.utils.RedisUtil;
import com.llk.scaffold.model.dto.ResponseBean;
import com.llk.scaffold.model.dto.UserDto;
import com.llk.scaffold.model.entity.User;
import com.llk.scaffold.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @className: LoginController
 * @description:
 * @author: LiuLukuan
 * @date: 2019/11/11 17:29
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody User userDto, HttpServletResponse httpServletResponse) {

        //UserDto userDto = JSON.parseObject(json, UserDto.class);

        // 查询数据库中的帐号信息
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp == null) {
            throw new RuntimeException("该帐号不存在(The account does not exist.)");
        }

        // 密码进行AES加密
        String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());

        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(userDtoTemp.getPassword())) {

            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            RedisUtil.set(RedisUtil.getTokenKey(userDto.getAccount()), currentTimeMillis, JwtUtil.REFRESH_TOKEN_EXPIRE_TIME);

            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(userDto.getAccount(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new RuntimeException("帐号或密码错误(Account or Password Error.)");
        }
    }
}
