package org.tsubakice.data.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "简短烈士信息实体")
public class MartyrItemView {

    @Schema(description = "烈士 id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer mid;

    @Schema(description = "烈士名称", example = "王世迁", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}
