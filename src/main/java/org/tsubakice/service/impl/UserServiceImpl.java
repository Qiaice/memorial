package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.table.User;
import org.tsubakice.mapper.UserMapper;
import org.tsubakice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
    public User getUserByUname(String uname) {
        return userMapper.selectUserByUname(uname);
    }
}
