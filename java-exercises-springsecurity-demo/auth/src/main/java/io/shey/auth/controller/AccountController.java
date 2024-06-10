package io.shey.auth.controller;

import io.shey.auth.common.Result;
import io.shey.auth.domain.Account;
import io.shey.auth.exception.TheAuthException;
import io.shey.auth.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        Map<String, Object> result = accountService.login(account);
        if (!result.get("token").equals("")) {
            return Result.success().message("登录成功").data("map", result);
        }
        return Result.error().message("用户名或密码错误");
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");

        if (ObjectUtils.isEmpty(token)) {
            throw new TheAuthException("token为空");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication); // 清除SecurityContextHolder中的认证信息，上下文
            stringRedisTemplate.delete("token_" + token);
        }

        return Result.success();
    }
}
