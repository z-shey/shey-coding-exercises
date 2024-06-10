package io.shey.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.shey.auth.domain.Account;
import io.shey.auth.mapper.AccountMapper;
import io.shey.auth.mapper.PermissionMapper;
import io.shey.auth.mapper.RoleMapper;
import io.shey.auth.vo.AccountDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (ObjectUtils.isEmpty(username)) {
            throw new InternalAuthenticationServiceException(null);
        }

        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", username);
        Account account = accountMapper.selectOne(queryWrapper);

        if (Objects.isNull(account)) {
            throw new UsernameNotFoundException(null);
        }

        String role = roleMapper.selectRoleByAccountID(account.getAccountId());
        List<String> permissions = permissionMapper.selectPermissionByAccountID(account.getAccountId());

        return new AccountDetails(account, role, permissions);
    }
}
