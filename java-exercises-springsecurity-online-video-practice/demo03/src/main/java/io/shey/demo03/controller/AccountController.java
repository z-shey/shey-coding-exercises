package io.shey.demo03.controller;

import io.jsonwebtoken.lang.Strings;
import io.shey.demo03.common.R;
import io.shey.demo03.model.entity.Account;
import io.shey.demo03.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public R login(@RequestBody Account account) {
        String jwt = accountService.login(account);
        if (Strings.hasLength(jwt)) {
            return R.ok().data("token", jwt).message("登录成功");
        }

        return R.error().data("token", null).message("登录失败");
    }
}
