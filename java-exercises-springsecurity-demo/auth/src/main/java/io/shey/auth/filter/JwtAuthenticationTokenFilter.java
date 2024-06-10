package io.shey.auth.filter;

import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import io.shey.auth.exception.TheAuthException;
import io.shey.auth.handler.TheAuthenticationFailureHandler;
import io.shey.auth.utils.JwtUtil;
import io.shey.auth.vo.AccountDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 实现一个JWT认证的过滤器，用于验证请求中的JWT令牌，每一次请求都会经过这个过滤器
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private TheAuthenticationFailureHandler theAuthenticationFailureHandler;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 在每次请求时都会执行该方法
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (!request.getRequestURI().equals("/api/account/login")) {
                this.validateToken(request);
            }
        } catch (AuthenticationException e) {
            theAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 验证JWT令牌的有效性
     *
     * @param request
     */
    private void validateToken(HttpServletRequest request) {
        // 获取请求中的JWT令牌
        String token = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(token)) {
            throw new TheAuthException("token为空");
        }

        String redisString = stringRedisTemplate.opsForValue().get("token_" + token);
        if (ObjectUtils.isEmpty(redisString)) {
            throw new TheAuthException("token过期");
        }

        // 解析JWT令牌
        AccountDetails accountDetails;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            // 验证JWT令牌的有效性
            String subject = claims.getSubject();
            accountDetails = JSON.parseObject(subject, AccountDetails.class);
        } catch (Exception e) {
            throw new TheAuthException("token无效");
        }

        // 把验证完获取到的用户信息再次放入security的上下文中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(accountDetails, null, accountDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
