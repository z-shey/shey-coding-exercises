package io.shey.demo02.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.shey.demo02.model.entity.UserAccount;
import io.shey.demo02.model.vo.LoginUser;
import io.shey.demo02.service.UserAccountService;
import io.shey.demo02.mapper.UserAccountMapper;
import io.shey.demo02.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author shey
 * @description 针对表【user_account】的数据库操作Service实现
 * @createDate 2024-06-03 19:52:43
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(UserAccount userAccount) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userAccount.getUserAccount(), userAccount.getUserPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误！！！！！！！");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String jsonString = JSON.toJSONString(loginUser);

        // 生成JWT
        return JwtUtil.createJWT(jsonString, null);
    }
}




