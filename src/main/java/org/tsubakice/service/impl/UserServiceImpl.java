package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.tsubakice.data.table.User;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.mapper.UserMapper;
import org.tsubakice.resource.ResCode;
import org.tsubakice.resource.Result;
import org.tsubakice.service.UserService;
import org.tsubakice.util.JwtBuilder;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final JwtBuilder jwtBuilder;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JwtBuilder jwtBuilder) {
        this.userMapper = userMapper;
        this.jwtBuilder = jwtBuilder;
    }

    @Override
    public boolean isExists(String uname) {
        return userMapper.selectUserByUname(uname) != null;
    }

    @Override
    public boolean isNotExists(String uname) {
        return userMapper.selectUserByUname(uname) == null;
    }

    @Override
    public Result login(UserLoginTransfer transfer) {

        // 用户名不存在直接返回登录失败
        User user = userMapper.selectUserByUname(transfer.getUname());
        if (user == null) {
            return Result.fail(
                    ResCode.LOGIN_FAIL, "用户 " + transfer.getUname() + " 不存在");
        }

        // 密码一致即可判定用户登录成功
        if (DigestUtils.md5DigestAsHex(user.getPasswd().getBytes()).equals(transfer.getPasswd())) {
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
