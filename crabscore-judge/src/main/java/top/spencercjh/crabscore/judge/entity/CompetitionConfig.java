package top.spencercjh.crabscore.judge.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_competition_config
 */
@Data
@ApiModel(value="大赛信息配置对象模型")
public class CompetitionConfig {

    @ApiModelProperty(value = "唯一标识")
    private Integer id;

    @ApiModelProperty(value = "大赛id")
    private Integer competitionId;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;

    public CompetitionConfig() {
    }

}