package org.tsubakice.data.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Martyr {

    private Integer mid; // 唯一 id 标识
    private Integer fid; // 烈士所属烈士纪念设施 id
    private String photo; // 烈士碑像
    private String name; // 姓名
    private String hometown; // 籍贯
    private Integer gender; // 性别
    private String politicsStatus; // 政治面貌
    private String birthDate; // 出生日期
    private String dept; // 生前单位
    private String position; // 生前职位
    private String achievement; // 立功情况
    private String deathDate; // 牺牲日期
    private String deathCampaign; // 牺牲战役
    private String deathAddress; // 牺牲地址
    private String buryPoint; // 安葬地点
    private String deeds; // 烈士事迹
    private LocalDateTime ctime; // 烈士信息记录时间
    private LocalDateTime mtime; // 烈士信息修改时间
}
