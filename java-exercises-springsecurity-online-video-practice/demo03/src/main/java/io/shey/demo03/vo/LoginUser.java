package io.shey.demo03.vo;

import com.alibaba.fastjson2.annotation.JSONField;
import io.shey.demo03.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {
    private Account account;
    private List<String> roleList;

    public LoginUser(Account account, List<String> roleList) {
        this.account = account;
        this.roleList = roleList;
    }

    // 自定义权限列表集合
    @JSONField(serialize = false)
    List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }

        authorities = new ArrayList<>();
        for (String role : roleList) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getUserPassword();
    }

    @Override
    public String getUsername() {
        return account.getUserAccount();
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
