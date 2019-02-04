package top.spencercjh.crabscore.company.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_score_taste
 */
@Data
@ApiModel(value = "口感分数对象模型")
public class TasteScore {

    @ApiModelProperty(value = "唯一标识 口感分数id")
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

    @ApiModelProperty(value = "蟹盖颜色")
    private Float scoreYgys;

    @ApiModelProperty(value = "鳃颜色")
    private Float scoreSys;

    @ApiModelProperty(value = "膏、黄颜色")
    private Float scoreGhys;

    @ApiModelProperty(value = "腥味、香味")
    private Float scoreXwxw;

    @ApiModelProperty(value = "膏、黄")
    private Float scoreGh;

    @ApiModelProperty(value = "腹部肌肉")
    private Float scoreFbjr;

    @ApiModelProperty(value = "第二、三步足肌肉")
    private Float scoreBzjr;

    @ApiModelProperty(value = "创建用户")
    private Date createDate;

    @ApiModelProperty(value = "最终给分")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

    @ApiModelProperty(value = "赛事信息（为0时代表永久有效）")
    private Integer competitionId;

}