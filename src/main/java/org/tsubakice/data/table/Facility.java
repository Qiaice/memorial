package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    private Integer fid; // 唯一 id 标识
    private Integer cid; // 所属城市 id
    private String name; // 设施名称
    private String img; // 设施图片
    private String intro; // 介绍
    private String phone; // 联系方式
    private String address; // 设施地址
    private String hint; // 乘车提示
    private LocalDateTime ctime; // 登记时间
    private LocalDateTime mtime; // 修改时间
}
