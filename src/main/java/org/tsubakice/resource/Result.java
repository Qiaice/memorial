package org.tsubakice.resource;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "统一响应数据载体")
public class Result {

    @Schema(description = "响应状态码", example = "200")
    private Integer code;

    @Schema(description = "响应结果的描述", example = "登录成功")
    private String message;

    @Schema(description = "响应的数据", example = "null")
    private Object data;

    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(String message) {
        return new Result(200, message, null);
    }

    public static Result success(Integer code, String message) {
        return new Result(code, message, null);
    }

    public static Result success(String message, Object data) {
        return new Result(200, message, data);
    }

    public static Result success(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result fail(String message) {
        return new Result(400, message, null);
    }

    public static Result fail(Integer code, String message) {
        return new Result(code, message, null);
    }

    public static Result fail(String message, Object data) {
        return new Result(400, message, data);
    }

    public static Result fail(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }
}
