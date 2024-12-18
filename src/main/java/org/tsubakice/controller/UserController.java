package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.common.ResCode;
import org.tsubakice.common.Result;
import org.tsubakice.service.UserService;

@Tag(name = "用户管理模块")
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

    @PostMapping(value = "/reset")
    public Result resetPasswd(
            @RequestBody UserRegisterTransfer transfer
    ) {
        boolean flag = userService.resetPasswdByUname(transfer.getUname(),
                transfer.getPasswd(), transfer.getPasswd2());
        return flag ? Result.success(ResCode.SUCCESS, "更新成功") :
                Result.fail(ResCode.FAIL, "更新失败");
    }
}
