package top.spencercjh.crabscore.admin.dao;

import org.springframework.stereotype.Repository;
import top.spencercjh.crabscore.admin.entity.CompetitionConfig;

/**
 * 大赛配置数据处理层
 *
 * @author spencercjh
 */
@Repository
public interface CompetitionConfigMapper {
    /**
     * 通过主键删除
     *
     * @param id 大赛id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过记录插入
     *
     * @param record 大赛配置记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(CompetitionConfig record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 大赛配置记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(CompetitionConfig record);

    /**
     * 通过主键查找
     *
     * @param id 大赛配置id
     * @return 大赛配置记录
     * @mbggenerated
     */
    CompetitionConfig selectByPrimaryKey(Integer id);

    /**
     * 通过主键选择性地更新
     *
     * @param record 大赛配置记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompetitionConfig record);

    /**
     * 通过主键更新
     *
     * @param record 大赛配置记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(CompetitionConfig record);
}