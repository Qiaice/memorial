package org.tsubakice.data.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "城市信息实体")
public class CityInfoView {

    @Schema(description = "城市 id", example = "15", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer cid;

    @Schema(description = "城市名称", example = "达州市", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}
