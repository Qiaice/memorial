package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    private Integer rid; // 唯一 id 标识
    private Integer uid; // 用户唯一 id 标识
    private Integer mid; // 烈士唯一 id 标识
    private Integer candle; // 是否点燃蜡烛    0 -> 未点燃    1 -> 点燃
    private Integer flower; // 献花朵数
    private String message; // 留言
    private LocalDateTime ctime; // 纪念时间
}
