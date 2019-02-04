package top.spencercjh.crabscore.company.dao;

import top.spencercjh.crabscore.company.entity.Group;
import top.spencercjh.crabscore.company.entity.dto.GroupResult;
import top.spencercjh.crabscore.company.entity.dto.RankResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 小组数据层
 *
 * @author spencercjh
 */
@Repository
public interface GroupMapper {
    /**
     * 查询在某一届大赛中的所有组
     *
     * @param competitionId 大赛Id
     * @return 所有符合条件的组记录
     */
    List<GroupResult> selectAllGroupOneCompetition(@Param("competitionId") Integer competitionId);

    /**
     * 查询在某一届大赛中的所有组并按照种质成绩从大到小排列
     *
     * @param competitionId 大赛Id
     * @return 所有符合条件的组记录
     */
    List<RankResult> selectAllGroupOneCompetitionOrderByQualityScore(@Param("competitionId") Integer competitionId);

    /**
     * 查询在某一届大赛中的所有组并按照口感成绩从大到小排列
     *
     * @param competitionId 大赛Id
     * @return 所有符合条件的组记录
     */
    List<RankResult> selectAllGroupOneCompetitionOrderByTasteScore(@Param("competitionId") Integer competitionId);

    /**
     * 查询在某一届大赛中的所有组并按照肥满度成绩从大到小排列
     *
     * @param competitionId 大赛Id
     * @return 所有符合条件的组记录
     */
    List<RankResult> selectAllGroupOneCompetitionOrderByFatnessScore(@Param("competitionId") Integer competitionId);

    /**
     * 查询在某一届大赛中某一参选单位的所有组
     *
     * @param competitionId 大赛Id
     * @param companyId     参选单位Id
     * @return 所有符合条件的组记录
     */
    List<GroupResult> selectAllGroupOneCompetitionOneCompany(@Param("competitionId") Integer competitionId, @Param("companyId") Integer companyId);

    /**
     * 通过主键删除
     *
     * @param groupId 小组id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer groupId);

    /**
     * 通过记录插入
     *
     * @param record 小组记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(Group record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 小组记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(Group record);

    /**
     * 通过主键查找
     *
     * @param groupId 小组id
     * @return 小组记录
     * @mbggenerated
     */
    Group selectByPrimaryKey(Integer groupId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 小组记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * 通过主键更新
     *
     * @param record 小组记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(Group record);
}