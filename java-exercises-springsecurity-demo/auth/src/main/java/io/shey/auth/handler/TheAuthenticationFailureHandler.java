package io.shey.auth.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.shey.auth.common.ErrorCode;
import io.shey.auth.common.Result;
import io.shey.auth.exception.TheAuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class TheAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8"); // 请求头
        ServletOutputStream outputStream = response.getOutputStream();

        String message = "";
        int errorCode = 0;

        if (exception instanceof AccountExpiredException) {
            message = "账户过期";
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        } else if (exception instanceof BadCredentialsException) {
            message = "账号或密码错误";
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        } else if (exception instanceof DisabledException) {
            message = "账户被禁用";
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        } else if (exception instanceof LockedException) {
            message = "账户被锁定";
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        } else if (exception instanceof InternalAuthenticationServiceException) {
            message = "账户不存在";
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        } else if (exception instanceof TheAuthException) {
            message = exception.getMessage();
            errorCode = ErrorCode.ERROR_ACCOUNT.getCode();
        }

        String jsonString = JSON.toJSONString(Result.error().message(message).code(errorCode), SerializerFeature.DisableCircularReferenceDetect);
        outputStream.write(jsonString.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
