package top.spencercjh.crabscore.company.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author spencercjh
 */
@Data
public class CrabScoreResult {
    private Integer crabId;

    private Integer groupId;

    private Integer crabSex;

    private String crabLabel;

    private Float crabWeight;

    private Float crabLength;

    private Float crabFatness;

    private Float qualityScoreFin;

    private Float tasteScoreFin;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private Integer competitionId;

    private String avatarUrl;
}
