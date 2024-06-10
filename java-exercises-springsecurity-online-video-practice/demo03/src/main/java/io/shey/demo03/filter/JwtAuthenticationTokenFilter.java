package io.shey.demo03.filter;

import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Strings;
import io.shey.demo03.vo.LoginUser;
import io.shey.demo03.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// 实现一个JWT认证的过滤器，用于验证请求中的JWT令牌，每一次请求都会经过这个过滤器
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 放行登录接口
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/account/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 获取请求中的JWT令牌
        String token = request.getHeader("Authorization");
        if (!Strings.hasText(token)) {
            throw new RuntimeException("JWT令牌不能为空");
        }

        // 解析JWT令牌
        LoginUser loginUser = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            // 验证JWT令牌的有效性
            String subject = claims.getSubject();
            loginUser = JSON.parseObject(subject, LoginUser.class);
        } catch (Exception e) {
            throw new RuntimeException("JWT令牌无效");
        }

        // 把验证完获取到的用户信息再次放入security的上下文中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(request, response);
    }
}
