package com.spring.demo.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.demo.security.entity.Users;
import com.spring.demo.security.mapper.UsersMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author Major Tom
 * @date 2021/8/25 11:55
 * @description 自定义实现类
 */

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = usersMapper.selectOne(wrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(user.getUserName(), new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
