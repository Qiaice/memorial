package org.tsubakice.data.transfer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户注册信息实体")
public class UserRegisterTransfer {

    @Schema(description = "用户名", example = "zhangsan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String uname;

    @Schema(description = "用户密码", example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String passwd;

    @Schema(description = "确认用户密码，需要和用户密码一致", example = "123456", requiredMode = Schema.RequiredMode.REQUIRED)
    private String passwd2;
}
