package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Integer cid; // 唯一 id 标识
    private String name; // 城市名称
    private LocalDateTime ctime; // 城市信息记录时间
    private LocalDateTime mtime; // 城市信息修改时间
}
