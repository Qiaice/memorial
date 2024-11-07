package org.tsubakice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.web.servlet.ServletComponentScan;

// @ServletComponentScan // 启用 cors 过滤器(前期不要启用)
@SpringBootApplication
public class MemorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemorialApplication.class, args);
    }

}
