package io.shey.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AccountPasswordEncodeTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void encode() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

        boolean matches = passwordEncoder.matches("123456", encode);
        System.out.println(matches);
    }
}
