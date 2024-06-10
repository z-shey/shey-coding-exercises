package io.shey.auth.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import io.shey.auth.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class AccountDetails implements UserDetails {
    private Account account; // 账户
    private String role; // 角色
    private List<String> permissions; // 权限列表

    public AccountDetails(Account account, String role, List<String> permissions) {
        this.account = account;
        this.role = role;
        this.permissions = permissions;
    }

    @JSONField(serialize = false)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 权限
        permissions.forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));

        // 角色
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getAccountPassword();
    }

    @Override
    public String getUsername() {
        return account.getAccountName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
