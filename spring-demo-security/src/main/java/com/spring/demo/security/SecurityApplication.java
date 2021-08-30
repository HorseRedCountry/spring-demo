package com.spring.demo.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Major Tom
 * @date 2021/8/23 17:42
 * @description 启动类
 */
@SpringBootApplication
@MapperScan(value = "com.spring.demo.security.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
