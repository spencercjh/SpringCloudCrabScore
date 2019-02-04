package top.spencercjh.crabscore.judge.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_company_info
 */
@Data
@ApiModel(value="参选单位对象模型")
public class Company {

    @ApiModelProperty(value = "唯一标识 参选单位id")
    private Integer companyId;

    @ApiModelProperty(value = "参选单位名")
    private String companyName;

    @ApiModelProperty(value = "参加的大赛id 1为全部大赛")
    private Integer competitionId;

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