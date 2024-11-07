package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    private Integer lid; // 唯一 id 标识
    private String log; // 提交的日志
    private LocalDateTime time; // 日志提交时间
}
