package com.llk.scaffold.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description:
 * @author: LiuLukuan
 * @date: 2019/11/9 14:19
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello llk";
    }
}
