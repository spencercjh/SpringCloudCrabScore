package top.spencercjh.crabscore.company.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_crab_info
 */
@Data
@ApiModel(value="螃蟹对象模型")
public class Crab {

    @ApiModelProperty(value = "唯一标识 螃蟹id")
    private Integer crabId;

    @ApiModelProperty(value = "所属小组id")
    private Integer groupId;

    @ApiModelProperty(value = "性别，0:雌 1 雄")
    private Integer crabSex;

    @ApiModelProperty(value = "螃蟹标签")
    private String crabLabel;

    @ApiModelProperty(value = "重量")
    private Float crabWeight;

    @ApiModelProperty(value = "长度")
    private Float crabLength;

    @ApiModelProperty(value = "肥满度")
    private Float crabFatness;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

    @ApiModelProperty(value = "大赛id")
    private Integer competitionId;

    @ApiModelProperty(value = "头像链接")
    private String avatarUrl;
}