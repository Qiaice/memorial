package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.data.table.User;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.resource.ResCode;
import org.tsubakice.resource.Result;
import org.tsubakice.service.UserService;
import org.tsubakice.util.JwtBuilder;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = { "/users" }, produces = { "application/json; charset=utf-8" })
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "用户注册接口",
            description = "该接口用于用户注册，需要以 post+json 方式提交用户的注册信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "REGISTER_SUCCESS", description = "用户注册成功"),
            @ApiResponse(responseCode = "REGISTER_FAIL", description = "用户注册失败")
    })
    @PostMapping(value = { "/register" })
    public Result register(
            @RequestBody UserRegisterTransfer transfer
    ) {
        log.info("新增用户:{}",transfer);
        // 用户注册所需逻辑
        // 注册成功: return Result.success(ResCode.REGISTER_SUCCESS, "注册成功", token)
        // 注册失败: return Result.fail(ResCode.REGISTER_FAIL, "注册失败");
        return userService.register(transfer);
    }

    @Operation(
            summary = "用户登录接口",
            description = "该接口用于用户登录，需要以 post+json 方式提交用户的登录信息")
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

        // 返回用户登录的结果
        return userService.login(transfer);
    }
}
