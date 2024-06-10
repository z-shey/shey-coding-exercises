package io.shey.demo03.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.shey.demo03.domain.Account;
import io.shey.demo03.mapper.AccountMapper;
import io.shey.demo03.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询账户信息
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", username);
        Account account = accountMapper.selectOne(queryWrapper);
        if (Objects.isNull(account)) {
            throw new UsernameNotFoundException("UserServiceImpl 用户不存在");
        }

        // todo 权限操作
        List<String> listRole = new ArrayList<>();
        listRole.add("select");
        listRole.add("update");
        listRole.add("delete");

        // 返回UserDetail对象
        return new LoginUser(account, listRole);
    }
}
