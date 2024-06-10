package io.shey.demo02.controller;

import io.shey.demo02.common.R;
import io.shey.demo02.model.entity.UserAccount;
import io.shey.demo02.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/login")
    public R login(@RequestBody UserAccount userAccount) {
        String jwt = userAccountService.login(userAccount);

        if (StringUtils.hasLength(jwt)) {
            return R.ok().data("token", jwt).message("登录成功");
        }

        return R.error().message("用户名或密码错误");
    }
}
