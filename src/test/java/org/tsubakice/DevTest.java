package org.tsubakice;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class DevTest {

    @Test
    public void md5Tst() {
        //测试推送
        String str = DigestUtils.md5DigestAsHex("040905".getBytes());
        System.out.println(str);
    }
}
