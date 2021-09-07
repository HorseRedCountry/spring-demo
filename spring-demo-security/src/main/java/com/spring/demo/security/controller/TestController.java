package com.spring.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试--前端控制器
 * </P>
 *
 * @author Major Tom
 * @since 2021/9/7 15:40
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Security!";
    }

    @GetMapping(value = "/hello2")
    public String index(){
        return "Hello index";
    }
}
