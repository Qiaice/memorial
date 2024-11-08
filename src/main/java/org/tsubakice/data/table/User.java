package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer uid; // 唯一 id 标识
    private String uname; // 用户名
    private String passwd; // 用户密码
    private Integer type; // 用户类型    1 -> 普通用户    2 -> 家属用户    3 -> 管理员
    private LocalDateTime ctime; // 用户注册时间
    private LocalDateTime mtime; // 修改用户信息时间
}
