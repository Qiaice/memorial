package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tsubakice.data.table.User;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.resource.ResCode;
import org.tsubakice.resource.Result;
import org.tsubakice.service.UserService;
import org.tsubakice.util.JwtBuilder;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "游离功能模块")
@RestController
@RequestMapping(value = { "/api" }, produces = { "application/json; charset=utf-8" })
public class FunctionController {

    private final UserService userService;
    private final JwtBuilder jwtBuilder;

    @Autowired
    public FunctionController(UserService userService, JwtBuilder jwtBuilder) {
        this.userService = userService;
        this.jwtBuilder = jwtBuilder;
    }

    @Operation(
            summary = "访问测试接口",
            description = "该接口用于测试是否能够访问到后端提供的服务")
    @ApiResponse(responseCode = "SUCCESS", description = "访问测试成功")
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
        return Result.success(ResCode.SUCCESS, "访问成功", Map.of(
                "headers", headers,
                "time", time)
        );
    }

    @Operation(
            summary = "用户注册接口",
            description = "该接口用于用户注册，需要以 post 方式提交用户的注册信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "REGISTER_SUCCESS", description = "用户注册成功"),
            @ApiResponse(responseCode = "REGISTER_FAIL", description = "用户注册失败")
    })
    @PostMapping(value = { "/register" })
    public Result register(
            @RequestBody UserRegisterTransfer transfer
    ) {
        // 用户注册所需逻辑

        // 注册成功: return Result.success(ResCode.REGISTER_SUCCESS, "注册成功", token)

        // 注册失败: return Result.fail(ResCode.REGISTER_FAIL, "注册失败");
        return null;
    }

    @Operation(
            summary = "用户登录接口",
            description = "该接口用于用户登录，需要以 post 方式提交用户的登录信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "LOGIN_SUCCESS", description = "用户登录成功"),
            @ApiResponse(responseCode = "LOGIN_FAIL", description = "用户登录失败")
    })
    @PostMapping(value = { "/login" })
    public Result login(
            @RequestBody UserLoginTransfer transfer
    ) {
        // 校验空数据
        String uname = transfer.getUname();
        String passwd = transfer.getPasswd();
        if (uname == null || passwd == null || uname.isEmpty() || passwd.isEmpty()) {
            return Result.fail(ResCode.LOGIN_FAIL, "不能传递空数据");
        }

        // 用户名不存在直接返回登录失败
        User user = userService.getUserByUname(transfer.getUname());
        if (user == null) {
            return Result.fail(
                    ResCode.LOGIN_FAIL, "用户 " + transfer.getUname() + " 不存在");
        }

        // 密码一致即可判定用户登录成功
        if (user.getPasswd().equals(transfer.getPasswd())) {
            return Result.success(
                    ResCode.LOGIN_SUCCESS,
                    "用户 " + transfer.getUname() + " 登录成功",
                    jwtBuilder.createToken(Map.of(
                            "uid", user.getUid(),
                            "uname", user.getUname()
                    ))
            );
        } else { // 否则判定用户登录失败
            return Result.fail(ResCode.LOGIN_FAIL, "密码错误");
        }
    }
}
