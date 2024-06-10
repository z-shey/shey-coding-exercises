package io.shey.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.shey.auth.domain.Account;
import io.shey.auth.service.AccountService;
import io.shey.auth.mapper.AccountMapper;
import io.shey.auth.utils.JwtUtil;
import io.shey.auth.vo.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author shey
 * @description 针对表【account(账号表)】的数据库操作Service实现
 * @createDate 2024-06-06 19:31:06
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, Object> login(Account account) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account.getAccountName(), account.getAccountPassword());

        // 执行认证逻辑
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 认证失败抛出异常
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("认证失败");
        }

        // 生成token
        AccountDetails accountDetails = (AccountDetails) authenticate.getPrincipal();
        String jsonString = JSON.toJSONString(accountDetails);
        String jwt = JwtUtil.createJWT(jsonString, null);

        // 将token存入redis，设置白名单
        stringRedisTemplate.opsForValue().set("token_" + jwt, jwt, JwtUtil.JWT_TTL / 1000, TimeUnit.SECONDS);

        Map<String, Object> result = new HashMap<>();
        result.put("token", jwt);

        return result;
    }
}




