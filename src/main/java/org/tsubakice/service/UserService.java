package org.tsubakice.service;

import org.tsubakice.data.transfer.UserLoginTransfer;
import org.tsubakice.data.transfer.UserRegisterTransfer;
import org.tsubakice.common.Result;

public interface UserService {

    /**
     * 判定用户是否存在
     * @param uname 用户名
     * @return 用户是否存在
     */
    public abstract boolean isExists(String uname);

    /**
     * 判定用户是否不存在
     * @param uname 用户名
     * @return 用户是否不存在
     */
    public abstract boolean isNotExists(String uname);

    /**
     * 用户登录功能实现
     * @param transfer 用户登录信息实体
     * @return 返回用户登录的响应
     */
    public abstract Result login(UserLoginTransfer transfer);

    /**
     * 用户注册功能实现
     * @param transfer 用户登注册息实体
     * @return 返回用户注册的响应
     */
    public abstract Result register(UserRegisterTransfer transfer);

    boolean resetPasswdByUname(String uname, String passwd, String passwd2);
}
