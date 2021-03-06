package top.spencercjh.crabscore.admin.service;

import top.spencercjh.crabscore.admin.entity.Competition;

import java.util.List;

/**
 * @author spencercjh
 */
public interface CompetitionService {
    /**
     * 查询所有大赛信息记录
     *
     * @return 所有大赛信息记录
     */
    List<Competition> selectAllCompetition();

    /**
     * 通过主键删除
     *
     * @param competitionId 大赛id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer competitionId);

    /**
     * 通过记录插入
     *
     * @param record 大赛信息记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(Competition record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 大赛信息记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(Competition record);

    /**
     * 通过主键查找
     *
     * @param competitionId 大赛配置id
     * @return 大赛信息记录
     * @mbggenerated
     */
    Competition selectByPrimaryKey(Integer competitionId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 大赛信息记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Competition record);

    /**
     * 通过主键更新
     *
     * @param record 大赛信息记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(Competition record);
}