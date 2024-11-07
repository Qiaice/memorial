package org.tsubakice.data.transfer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户登录信息实体")
public class UserLoginTransfer {

    @Schema(description = "用户名", example = "zhangsan")
    private String uname;

    @Schema(description = "用户密码", example = "123456")
    private String passwd;
}
