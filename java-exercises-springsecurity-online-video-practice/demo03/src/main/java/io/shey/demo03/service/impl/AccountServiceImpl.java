package io.shey.demo03.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.shey.demo03.domain.Account;
import io.shey.demo03.service.AccountService;
import io.shey.demo03.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
* @author shey
* @description 针对表【account】的数据库操作Service实现
* @createDate 2024-06-05 22:05:53
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

}




