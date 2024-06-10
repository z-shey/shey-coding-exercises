package io.shey.auth.config;

import io.shey.auth.filter.JwtAuthenticationTokenFilter;
import io.shey.auth.handler.TheAccessDeniedHandler;
import io.shey.auth.handler.TheAnonymousAuthenticationHandler;
import io.shey.auth.handler.TheAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security配置
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    // 自定义配置认证过滤器
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private TheAccessDeniedHandler theAccessDeniedHandler;

    @Autowired
    private TheAnonymousAuthenticationHandler theAnonymousAuthenticationHandler;

    @Autowired
    private TheAuthenticationFailureHandler theAuthenticationFailureHandler;

    /**
     * 密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器
     *
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * 安全配置
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable); // 跨站请求伪造

        httpSecurity.sessionManagement(configurer -> configurer
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // 无状态

        // 认证过滤器
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/account/login").permitAll()
                .requestMatchers("/doc.html", "/webjars/**", "/v2/api-docs", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated());

        // 认证过滤器顺序
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity.exceptionHandling(configurer -> configurer
                .accessDeniedHandler(theAccessDeniedHandler)
                .authenticationEntryPoint(theAnonymousAuthenticationHandler)
        );

        httpSecurity.formLogin(configurer -> configurer.failureHandler(theAuthenticationFailureHandler));

        return httpSecurity.build();
    }
}
