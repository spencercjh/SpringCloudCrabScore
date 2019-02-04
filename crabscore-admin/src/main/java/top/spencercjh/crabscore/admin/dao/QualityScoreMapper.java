package top.spencercjh.crabscore.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.spencercjh.crabscore.admin.entity.QualityScore;

import java.util.List;

/**
 * 种质分数数据层
 *
 * @author spencercjh
 */
@Repository
public interface QualityScoreMapper {
    /**
     * 通过大赛Id，小组ID和螃蟹性别来查找某一组某一性别的种质得分标准差
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别
     * @return average
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_MALE
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_FEMALE
     */
    Float sdQualityScoreByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                            @Param("groupId") Integer groupId,
                                                            @Param("crabSex") Integer crabSex);


    /**
     * 通过大赛Id，小组ID和螃蟹性别来查找某一组某一性别的平均种质得分
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别
     * @return average
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_MALE
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_FEMALE
     */
    Float averageQualityScoreByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                                 @Param("groupId") Integer groupId,
                                                                 @Param("crabSex") Integer crabSex);

    /**
     * 通过大赛Id，小组Id来查找种质分数信息
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @return 所有符合条件的种质分数信息记录
     */
    List<QualityScore> selectByCompetitionIdAndGroupId(@Param("competitionId") Integer competitionId,
                                                       @Param("groupId") Integer groupId);

    /**
     * 通过大赛Id，小组Id和螃蟹性别来查找种质分数信息
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别
     * @return 所有符合条件的种质分数信息记录
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_MALE
     * @see top.spencercjh.crabscore.admin.common.CommonConstant#CRAB_FEMALE
     */
    List<QualityScore> selectByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                                 @Param("groupId") Integer groupId,
                                                                 @Param("crabSex") Integer crabSex);

    /**
     * 通过主键删除
     *
     * @param scoreId 分数id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer scoreId);

    /**
     * 通过记录插入
     *
     * @param record 分数记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(QualityScore record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 分数记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(QualityScore record);

    /**
     * 通过主键查找
     *
     * @param scoreId 分数id
     * @return 分数记录
     * @mbggenerated
     */
    QualityScore selectByPrimaryKey(Integer scoreId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 分数记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QualityScore record);

    /**
     * 通过主键更新
     *
     * @param record 分数记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(QualityScore record);
}