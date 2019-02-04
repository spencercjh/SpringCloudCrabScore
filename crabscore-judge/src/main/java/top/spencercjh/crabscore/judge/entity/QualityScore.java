package top.spencercjh.crabscore.judge.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_score_quality
 */
@Data
@ApiModel(value = "种质分数对象模型")
public class QualityScore {

    @ApiModelProperty(value = "唯一标识 种质分数id")
    private Integer scoreId;

    @ApiModelProperty(value = "螃蟹id")
    private Integer crabId;

    @ApiModelProperty(value = "所属小组id")
    private Integer groupId;

    @ApiModelProperty(value = "性别，0:雌 1 雄")
    private Integer crabSex;

    @ApiModelProperty(value = "评委用户ID")
    private Integer userId;

    @ApiModelProperty(value = "最终给分")
    private Float scoreFin;

    @ApiModelProperty(value = "体色(背)")
    private Float scoreBts;

    @ApiModelProperty(value = "体色(腹)")
    private Float scoreFts;

    @ApiModelProperty(value = "额齿")
    private Float scoreEc;

    @ApiModelProperty(value = "第4侧齿")
    private Float scoreDscc;

    @ApiModelProperty(value = "背部疣状突")
    private Float scoreBbyzt;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

    @ApiModelProperty(value = "赛事信息（为0时代表永久有效）")
    private Integer competitionId;

}