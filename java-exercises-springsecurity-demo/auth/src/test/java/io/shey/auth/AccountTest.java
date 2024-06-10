package io.shey.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.shey.auth.domain.Account;
import io.shey.auth.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AccountTest {
    @Autowired
    AccountMapper accountMapper;

    @Test
    void accountTest() {
//        List<Account> accounts = accountMapper.selectList(null);
//        accounts.forEach(System.out::println);
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", "eve");

        Account account = accountMapper.selectOne(queryWrapper);

        System.out.println(account);
    }
}
