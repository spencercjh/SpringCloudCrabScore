package top.spencercjh.crabscore.judge.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 */
@Data
@ApiModel(value = "大赛信息对象模型")
public class Competition {

    @ApiModelProperty(value = "唯一标识 大赛id")
    private Integer competitionId;

    @ApiModelProperty(value = "大赛年份")
    private String competitionYear;

    @ApiModelProperty(value = "雄蟹肥满度参数")
    private Float varFatnessM;

    @ApiModelProperty(value = "雌蟹肥满度参数")
    private Float varFatnessF;

    @ApiModelProperty(value = "雄蟹体重参数")
    private Float varWeightM;

    @ApiModelProperty(value = "雌蟹体重参数")
    private Float varWeightF;

    @ApiModelProperty(value = "雄蟹肥满度标准差参数")
    private Float varMfatnessSd;

    @ApiModelProperty(value = "雄蟹体重标准差参数")
    private Float varMweightSd;

    @ApiModelProperty(value = "雌蟹肥满度标准差参数")
    private Float varFfatnessSd;

    @ApiModelProperty(value = "雌蟹体重标准差参数")
    private Float varFweightSd;

    @ApiModelProperty(value = "肥满度排名 1:允许查看排名,0不允许查看排名")
    private Integer resultFatness;

    @ApiModelProperty(value = "种质分排名 1:允许查看排名,0不允许查看排名")
    private Integer resultQuality;

    @ApiModelProperty(value = "口感分排名 1:允许查看排名,0不允许查看排名")
    private Integer resultTaste;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "大赛状态 1：可用 0：禁用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

    @ApiModelProperty(value = "头像链接")
    private String avatarUrl;
}