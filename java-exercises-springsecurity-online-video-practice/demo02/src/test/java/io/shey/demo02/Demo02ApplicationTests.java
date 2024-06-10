package io.shey.demo02;

import io.jsonwebtoken.Claims;
import io.shey.demo02.model.entity.UserAccount;
import io.shey.demo02.mapper.UserAccountMapper;
import io.shey.demo02.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class Demo02ApplicationTests {

    @Test
    void contextLoads() {
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
    private UserAccountMapper userAccountMapper;


    @Test
    void accountTest() {
        List<UserAccount> userAccounts = userAccountMapper.selectList(null);
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
