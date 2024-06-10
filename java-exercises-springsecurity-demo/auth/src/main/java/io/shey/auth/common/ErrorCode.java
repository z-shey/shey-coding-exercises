package io.shey.auth.common;

import lombok.Getter;

/**
 * 错误码枚举
 */
@Getter
public enum ErrorCode {
    SUCCESS(0, "Success"),
    ERROR(-1, "Error"),
    ERROR_ACCOUNT(50000, "Error"),
    ERROR_PARAMS(40000, "Request parameter error");

    private final Integer code;
    private final String message;

    /**
     * 构造函数
     *
     * @param code    错误码
     * @param message 错误信息
     */
    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
