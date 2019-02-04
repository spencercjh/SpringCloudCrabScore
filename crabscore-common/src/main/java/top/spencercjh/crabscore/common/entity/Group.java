package top.spencercjh.crabscore.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_group_info
 */
@Data
@ApiModel(value="小组对象模型")
public class Group {

    @ApiModelProperty(value = "唯一标识 小组id")
    private Integer groupId;

    @ApiModelProperty(value = "所属参选单位id")
    private Integer companyId;

    @ApiModelProperty(value = "所属大赛id")
    private Integer competitionId;

    @ApiModelProperty(value = "雄蟹肥满度评分")
    private Float fatnessScoreM;

    @ApiModelProperty(value = "雄蟹种质评分")
    private Float qualityScoreM;

    @ApiModelProperty(value = "雄蟹口感评分")
    private Float tasteScoreM;

    @ApiModelProperty(value = "雌蟹口感评分")
    private Float fatnessScoreF;

    @ApiModelProperty(value = "雌蟹种质评分")
    private Float qualityScoreF;

    @ApiModelProperty(value = "雌蟹口感评分")
    private Float tasteScoreF;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

}