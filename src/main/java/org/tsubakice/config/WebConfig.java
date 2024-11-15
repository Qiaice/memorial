package org.tsubakice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.tsubakice.interceptor.TokenInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;

    @Autowired
    public WebConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册 token 拦截器
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**") // 默认过滤 FunctionController 模块下的所有请求
                .excludePathPatterns("/api/test") // 放行测试请求
                .excludePathPatterns("/api/register") // 放行注册请求
                .excludePathPatterns("/api/login") // 放行登录请求

                .addPathPatterns("/cities/**") // 默认过滤 CitiesController 模块下的所有请求

                .addPathPatterns("/martyrs/**"); // 默认过滤 MartyrController 模块下的所有请求
    }
}
