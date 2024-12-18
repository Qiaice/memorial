package org.tsubakice.data.view;

import lombok.Data;

@Data
public class FacilityView {

    private Integer fid; // 唯一 id 标识
    private String name; // 设施名称
    private String img; // 设施图片
}
