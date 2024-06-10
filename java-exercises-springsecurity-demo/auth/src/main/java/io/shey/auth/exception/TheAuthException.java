package io.shey.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Token 验证异常
 */
public class TheAuthException extends AuthenticationException {
    public TheAuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TheAuthException(String msg) {
        super(msg);
    }
}
