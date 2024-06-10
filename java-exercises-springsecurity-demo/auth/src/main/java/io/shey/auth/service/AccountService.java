package io.shey.auth.service;

import io.shey.auth.common.Result;
import io.shey.auth.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author shey
* @description 针对表【account(账号表)】的数据库操作Service
* @createDate 2024-06-06 19:31:06
*/
public interface AccountService extends IService<Account> {
    Map<String, Object> login(Account account);
}
