package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.resource.Result;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "游离功能模块")
@RestController
@RequestMapping(value = { "/api" })
public class FunctionController {

    @Operation(
            summary = "访问测试接口",
            description = "该接口用于测试是否能够访问到后端提供的服务"
    )
    @GetMapping(value = { "/test" })
    public Result test(HttpServletRequest request) {

        // 存储携带的请求头，并将请求头回送给用户
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            headers.put(item, request.getHeader(item));
        }

        // 记录此次请求时间，一并回送给用户
        String time = LocalDateTime.now().toString().replace("T", " ");
        time = time.substring(0, time.indexOf("."));
        return Result.success("访问成功", Map.of(
                "headers", headers,
                "time", time)
        );
    }
}
