package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final JwtBuilder jwtBuilder;

    @Autowired
    public UserController(UserService userService, JwtBuilder jwtBuilder) {
        this.userService = userService;
        this.jwtBuilder = jwtBuilder;
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
        // 用户注册所需逻辑

        // 注册成功: return Result.success(ResCode.REGISTER_SUCCESS, "注册成功", token)

        // 注册失败: return Result.fail(ResCode.REGISTER_FAIL, "注册失败");
        return null;
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

        // 用户名不存在直接返回登录失败
        User user = userService.getUserByUname(transfer.getUname());
        log.info("user: {}", user);
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
