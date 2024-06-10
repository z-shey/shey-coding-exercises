package io.shey.demo02.model.vo;

import io.shey.demo02.model.entity.UserAccount;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private UserAccount userAccount;

    public LoginUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userAccount.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userAccount.getUserAccount();
    }

    // 判断账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 判断是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 判断有无超时
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 判断是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
