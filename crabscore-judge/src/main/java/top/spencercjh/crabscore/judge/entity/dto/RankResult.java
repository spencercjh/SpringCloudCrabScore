package top.spencercjh.crabscore.judge.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 */
@ApiModel("排名结果")
@Data
public class RankResult {
    @ApiModelProperty(value = "唯一标识 小组id")
    private Integer groupId;

    @ApiModelProperty(value = "所属参选单位id")
    private Integer companyId;

    @ApiModelProperty(value = "参选单位名")
    private String companyName;

    @ApiModelProperty(value = "参选单位头像链接")
    private String avatarUrl;

    @ApiModelProperty(value = "所属大赛id")
    private Integer competitionId;

    @ApiModelProperty(value = "分数")
    private Float score;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "更新用户")
    private String updateUser;
}
