package com.spring.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author Major Tom
 * @date 2021/8/24 11:01
 * @description Spring Security配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页面
        http.formLogin()
                //登录页面设置
                .loginPage("/login.html")
                //登录访问路径
                .loginProcessingUrl("/user/login")
                //登录成功之后，跳转路径
                .defaultSuccessUrl("/test/hello2").permitAll()
                //设置可以直接访问，无需认证的路径
                .and().authorizeRequests().antMatchers("/", "/test/hello", "/user/login").permitAll()
                .anyRequest().authenticated()
                //关闭scrf防护
                .and().csrf().disable();
    }
}
