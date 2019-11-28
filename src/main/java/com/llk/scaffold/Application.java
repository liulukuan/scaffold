package com.llk.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: Application
 * @description: 启动类
 * @author: LiuLukuan
 * @date: 2019/11/21 17:05
 */
@MapperScan(basePackages = {"com.llk.scaffold.dao"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
