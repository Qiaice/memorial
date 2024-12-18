package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.tsubakice.data.table.User;
import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.mapper.UserMapper;
import org.tsubakice.common.ResCode;
import org.tsubakice.common.Result;
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
        if (DigestUtils.md5DigestAsHex(transfer.getPasswd().getBytes()).equals(user.getPasswd())) {
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

    @Override
    public Result register(UserRegisterTransfer transfer) {
        //用户名冲突直接返回注册失败
        User transferUser = userMapper.selectUserByUname(transfer.getUname());
        if (transferUser != null)
            return Result.fail(ResCode.REGISTER_FAIL, "用户名冲突");
        //密码不一致直接返回注册失败
        if (!transfer.getPasswd().equals(transfer.getPasswd2()))
            return Result.fail(ResCode.REGISTER_FAIL, "两次密码不一致");
        //密码加密
        String passwd = DigestUtils.md5DigestAsHex(transfer.getPasswd().getBytes());
        // 将用户注册信息转换为数据库实体
        User user = User.builder()
                .passwd(passwd)
                .uname(transfer.getUname())
                .build();
        userMapper.insertUser(user);
        String token = jwtBuilder.createToken(Map.of(
                "uid", user.getUid(),
                "uname", user.getUname()
        ));
        //返回用户注册的结果
        return Result.success(ResCode.REGISTER_SUCCESS, "注册成功", token);
    }

    @Override
    public boolean resetPasswdByUname(String uname, String passwd, String passwd2) {
        User user = userMapper.selectUserByUname(uname);
        if (user == null) {
            return false;
        }
        if (!passwd.equals(passwd2)) {
            return false;
        }
        passwd = DigestUtils.md5DigestAsHex(passwd2.getBytes());
        return userMapper.updatePasswdByUname(uname, passwd) > 0;
    }
}
