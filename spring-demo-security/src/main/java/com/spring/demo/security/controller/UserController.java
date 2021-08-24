package com.spring.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Major Tom
 * @date 2021/8/24 11:29
 * @description 用户控制器
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/add")
    public String add(){
        return "Hello Security!";
    }
}
