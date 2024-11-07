package org.tsubakice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        // 标题
                        .title("英烈纪念网 api 接口文档")
                        // 接口描述
                        .description("提供英烈纪念网后端接口服务...")
                        // 版本
                        .version("v1.0.0")
                        // 作者及联系方式
                        .contact(new Contact().name("tsubaki").email("boyi.zh.life@outlook.com"))
                        // 设置许可证
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        // api 服务条款
                        .termsOfService("https://github.com/tsubaki")
                );
    }
}
