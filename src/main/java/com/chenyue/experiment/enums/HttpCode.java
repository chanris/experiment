package com.chenyue.experiment.enums;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/19
 */
public enum HttpCode {
    SUCCESS(200,"成功"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    UNAUTHORIZED(401, "请求的数字签名不匹配!"),
    FORBIDDEN(403,"拒绝访问"),
    NOT_FOUND(404, "未找到该资源"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!");

    private final Integer code;
    private final String msg;

    HttpCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
