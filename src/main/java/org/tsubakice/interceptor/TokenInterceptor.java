package org.tsubakice.interceptor;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.tsubakice.common.Result;
import org.tsubakice.util.JwtBuilder;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtBuilder jwtBuilder;

    @Autowired
    public TokenInterceptor(JwtBuilder jwtBuilder) {
        this.jwtBuilder = jwtBuilder;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        // 设置响应数据类型为 json 格式
        response.setHeader("Content-Type", "application/json; charset=utf-8");

        // 检查携带的 token
        String token = request.getHeader("Authorization");
        if (token == null) { // 拦截没有携带 token 的请求
            response.getOutputStream()
                    .write(JSON.toJSONString(Result.fail("没有携带 token")).getBytes());
            return false;
        } /*else if (!token.startsWith("Bearer ")) { // 拦截 token 格式错误的请求
            response.getOutputStream()
                    .write(JSON.toJSONString(Result.fail("token 格式有误")).getBytes());
            return false;
        }*/

        // 检查 token 是否有效
        try {
//            jwtBuilder.parseToken(token.split(" ")[1]);
            jwtBuilder.parseToken(token);
        } catch (Exception e) {
            response.getOutputStream()
                    .write(JSON.toJSONString(Result.fail("token 解析失败")).getBytes());
            return false;
        }

        // token 检查通过后放行
        return true;
    }
}
