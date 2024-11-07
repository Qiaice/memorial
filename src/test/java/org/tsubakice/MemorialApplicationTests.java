package org.tsubakice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tsubakice.util.JwtBuilder;

import java.util.Map;

@SpringBootTest
public class MemorialApplicationTests {

    @Autowired
    private JwtBuilder jwtBuilder;

    @Test
    public void contextLoads() {
        System.out.println("测试 token : " + jwtBuilder.createToken(
                Map.of("uname", "tsubaki"))
        );
    }
}
