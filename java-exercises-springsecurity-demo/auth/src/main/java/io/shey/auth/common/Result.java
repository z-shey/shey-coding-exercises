package io.shey.auth.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果封装
 */
@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private Result() {
    }

    /**
     * 成功返回结果
     *
     * @param success 是否成功
     * @return 返回结果
     */
    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * 返回信息结果
     *
     * @param message 提示信息
     * @return 返回结果
     */
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 返回错误码
     *
     * @param code 错误码
     * @return 返回结果
     */
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 返回数据
     *
     * @param key   数据内容键
     * @param value 数据内容值
     * @return 返回结果
     */
    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 成功返回结果
     *
     * @return 返回结果
     */
    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ErrorCode.SUCCESS.getCode());
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 失败返回结果
     *
     * @return 返回结果
     */
    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ErrorCode.ERROR.getCode());
        result.setMessage("操作失败");
        return result;
    }
}
