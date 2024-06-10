package io.shey.auth.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.shey.auth.common.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 匿名用户认证处理器
 */
@Component
public class TheAnonymousAuthenticationHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8"); // 请求头
        ServletOutputStream outputStream = response.getOutputStream();
        String jsonString = "";

        if (authException instanceof BadCredentialsException) {
            jsonString = JSON.toJSONString(Result.error().message(authException.getMessage()).code(HttpServletResponse.SC_UNAUTHORIZED), SerializerFeature.DisableCircularReferenceDetect);

        } else if (authException instanceof InternalAuthenticationServiceException) {
            jsonString = JSON.toJSONString(Result.error().message("用户名空").code(HttpServletResponse.SC_UNAUTHORIZED), SerializerFeature.DisableCircularReferenceDetect);
        } else {
            jsonString = JSON.toJSONString(Result.error().message("匿名无权限").code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), SerializerFeature.DisableCircularReferenceDetect);
        }

        outputStream.write(jsonString.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
