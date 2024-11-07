package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.resource.Result;
import org.tsubakice.service.UserService;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "游离功能模块")
@RestController
@RequestMapping(value = { "/api" })
public class FunctionController {

    private final UserService userService;

    @Autowired
    public FunctionController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "访问测试接口", description = "该接口用于测试是否能够访问到后端提供的服务")
    @GetMapping(value = { "/test" })
    public Result test(HttpServletRequest request) {

        // 存储携带的请求头，并将请求头回送给用户
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            headers.put(item, request.getHeader(item));
        }

        // 记录此次请求时间，一并回送给用户
        String time = LocalDateTime.now().toString().replace("T", " ");
        time = time.substring(0, time.indexOf("."));
        return Result.success("访问成功", Map.of(
                "headers", headers,
                "time", time)
        );
    }

    @Operation(
            summary = "用户注册接口",
            description = "该接口用于用户注册，需要以 post 方式提交用户的注册信息")
    @PostMapping(value = { "/register" })
    public Result register(
            @RequestBody UserRegisterTransfer transfer
    ) {
        // 用户注册所需逻辑
        return null;
    }

    @Operation(
            summary = "用户登录接口",
            description = "该接口用于用户登录，需要以 post 方式提交用户的登录信息")
    @PostMapping(value = { "/login" })
    public Result login(
            @RequestBody UserLoginTransfer transfer
    ) {
        // 用户登录所需逻辑
        return null;
    }
}
