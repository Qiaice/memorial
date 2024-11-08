package org.tsubakice.service;

import org.tsubakice.data.table.User;
import org.tsubakice.resource.ResCode;

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
     * 根据用户名查找用户
     * @param uname 用户名
     * @return 用户信息
     */
    public abstract User getUserByUname(String uname);
}
