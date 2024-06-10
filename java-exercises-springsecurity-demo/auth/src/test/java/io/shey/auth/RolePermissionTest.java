package io.shey.auth;

import io.shey.auth.mapper.PermissionMapper;
import io.shey.auth.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RolePermissionTest {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void roleTest() {
        String strings = roleMapper.selectRoleByAccountID(1L);
        System.out.println(strings);
    }

    @Test
    public void permissionTest() {
        List<String> strings = permissionMapper.selectPermissionByAccountID(1L);
        strings.forEach(System.out::println);
    }
}
