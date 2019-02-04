package top.spencercjh.crabscore.common.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 */
@Data
public class CrabResult {
    private Integer crabId;

    private Integer groupId;

    private Integer companyId;

    private String companyName;

    private Integer crabSex;

    private String crabLabel;

    private Float crabWeight;

    private Float crabLength;

    private Float crabFatness;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private Integer competitionId;

    private String avatarUrl;
}
