package io.shey.demo02.service;

import io.shey.demo02.model.entity.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author shey
 * @description 针对表【user_account】的数据库操作Service
 * @createDate 2024-06-03 19:52:43
 */
public interface UserAccountService extends IService<UserAccount> {
    String login(UserAccount userAccount);
}
