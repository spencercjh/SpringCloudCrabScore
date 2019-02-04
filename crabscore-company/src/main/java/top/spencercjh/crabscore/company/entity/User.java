package top.spencercjh.crabscore.company.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 * rxpb_user_info
 */
@Data
@ApiModel(value = "用户对象模型")
public class User {

    @ApiModelProperty(value = "唯一标识 用户id")
    private Integer userId;

    @ApiModelProperty(value = "绑定的参选单位Id")
    private Integer companyId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String displayName;

    @ApiModelProperty(value = "用户组id")
    private Integer roleId;

    @ApiModelProperty(value = "用户状态 1：可用 0：禁用")
    private Integer status;

    @ApiModelProperty(value = "邮箱 替换为手机")
    private String email;

    @ApiModelProperty(value = "赛事信息（为0时代表永久有效）")
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

    public User() {
    }

    public User(String userName, String password, String displayName, Integer roleId, Integer status,
                String email, Integer competitionId, Date createDate, String createUser, Date updateDate, String updateUser) {
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
        this.roleId = roleId;
        this.status = status;
        this.email = email;
        this.competitionId = competitionId;
        this.createDate = createDate;
        this.createUser = createUser;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
    }
}