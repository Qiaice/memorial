package org.tsubakice.resource;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "统一响应数据载体")
public class Result {

    @Schema(description = "响应状态码", example = "200")
    private ResCode code;

    @Schema(description = "响应结果的描述", example = "请求成功")
    private String message;

    @Schema(description = "响应的数据", example = "null")
    private Object data;

    private Result(ResCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(String message) {
        return new Result(ResCode.SUCCESS, message, null);
    }

    public static Result success(ResCode code, String message) {
        return new Result(code, message, null);
    }

    public static Result success(String message, Object data) {
        return new Result(ResCode.SUCCESS, message, data);
    }

    public static Result success(ResCode code, String message, Object data) {
        return new Result(code, message, data);
    }

    public static Result fail(String message) {
        return new Result(ResCode.FAIL, message, null);
    }

    public static Result fail(ResCode code, String message) {
        return new Result(code, message, null);
    }

    public static Result fail(String message, Object data) {
        return new Result(ResCode.FAIL, message, data);
    }

    public static Result fail(ResCode code, String message, Object data) {
        return new Result(code, message, data);
    }
}
