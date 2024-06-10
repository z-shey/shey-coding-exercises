package io.shey.demo02.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.shey.demo02.mapper.UserAccountMapper;
import io.shey.demo02.model.entity.UserAccount;
import io.shey.demo02.model.vo.LoginUser;
import io.shey.demo02.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名查询账号信息
        QueryWrapper<UserAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", username);
        UserAccount userAccount = userAccountMapper.selectOne(queryWrapper);
        if (Objects.isNull(userAccount)) {
//            throw new UsernameNotFoundException("用户不存在");
            throw new RuntimeException("用户不存在");
        }

        // 2. 判断密码是否正确

        // 3. 返回UserDetial对象
        return new LoginUser(userAccount);
    }

}
