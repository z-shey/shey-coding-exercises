package io.shey.demo03;

import io.jsonwebtoken.Claims;
import io.shey.demo03.mapper.AccountMapper;
import io.shey.demo03.model.entity.Account;
import io.shey.demo03.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class Demo03ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void JwtUtilTest() {
        // 生成jwt
        String jwt = JwtUtil.createJWT("123456", 3600L);
        System.out.println(jwt);

        // 解析jwt
        try {
            Claims claims = JwtUtil.parseJWT(jwt);
            System.out.println(claims.getId());
            System.out.println(claims.getSubject());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void accountTest() {
        List<Account> userAccounts = accountMapper.selectList(null);
        userAccounts.forEach(System.out::println);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordTest() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

        boolean matches = passwordEncoder.matches("123456", encode);
        System.out.println(matches);
    }
}
