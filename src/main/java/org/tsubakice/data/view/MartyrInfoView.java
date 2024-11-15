package org.tsubakice.data.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.tsubakice.data.table.Martyr;

@Data
@Schema(name = "烈士信息实体")
public class MartyrInfoView {

    @Schema(description = "烈士碑像", example = "/upload/file/2103/bd9585bde31a4c0393ccad9f28283700.png", requiredMode = Schema.RequiredMode.REQUIRED)
    private String photo;

    @Schema(description = "姓名", example = "王世迁", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "籍贯", example = "四川省达州市", requiredMode = Schema.RequiredMode.REQUIRED)
    private String hometown;

    @Schema(description = "性别", example = "男", requiredMode = Schema.RequiredMode.REQUIRED)
    private String gender;

    @Schema(description = "政治面貌", example = "不详")
    private String politicsStatus;

    @Schema(description = "出生日期", example = "1907")
    private String birthDate;

    @Schema(description = "生前单位", example = "红军")
    private String dept;

    @Schema(description = "生前职位", example = "战士")
    private String position;

    @Schema(description = "立功情况", example = "不详")
    private String achievement;

    @Schema(description = "牺牲日期", example = "1934")
    private String deathDate;

    @Schema(description = "牺牲战役", example = "平昌镇龙关作战中牺牲")
    private String deathCampaign;

    @Schema(description = "牺牲地址", example = "平昌镇龙关")
    private String deathAddress;

    @Schema(description = "安葬地点", example = "渠县八台山烈士陵园")
    private String buryPoint;

    @Schema(description = "烈士事迹", example = "1934，年在平昌镇龙关作战中牺牲")
    private String deeds;

    public MartyrInfoView(Martyr martyr) {
        this.photo = "https://www.sctyjrsw.com/image" + martyr.getPhoto();
        this.name = martyr.getName();
        this.hometown = martyr.getHometown();
        this.gender = switch (martyr.getGender()) {
            case 1 -> "男";
            case 2 -> "女";
            default -> "不详";
        };
        this.politicsStatus = martyr.getPoliticsStatus();
        this.birthDate = martyr.getBirthDate();
        this.dept = martyr.getDept();
        this.position = martyr.getPosition();
        this.achievement = martyr.getAchievement();
        this.deathDate = martyr.getDeathDate();
        this.deathCampaign = martyr.getDeathCampaign();
        this.deathAddress = martyr.getDeathAddress();
        this.buryPoint = martyr.getBuryPoint();
        this.deeds = martyr.getDeeds();
    }
}
