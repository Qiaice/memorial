package org.tsubakice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tsubakice.data.table.User;
import org.tsubakice.mapper.UserMapper;
import org.tsubakice.util.JwtBuilder;

import java.util.Map;

@SpringBootTest
public class MemorialApplicationTests {

    @Autowired
    private JwtBuilder jwtBuilder;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println("测试 token : " + jwtBuilder.createToken(
                Map.of("uname", "tsubaki"))
        );
    }

    @Test
    public void selectUserByUnameTest() {
        System.out.println(userMapper.selectUserByUname("tsubaki"));
    }

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setUname("tsubaki");
        user.setPasswd("040905");
        if (userMapper.insertUser(user) > 0) {
            System.out.println("添加用户成功");
        } else {
            System.out.println("添加用户失败");
        }
    }
}
