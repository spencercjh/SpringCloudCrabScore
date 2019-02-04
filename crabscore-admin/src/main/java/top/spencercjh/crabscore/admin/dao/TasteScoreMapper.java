package top.spencercjh.crabscore.admin.dao;

import top.spencercjh.crabscore.admin.entity.TasteScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 口感分数数据层
 *
 * @author spencercjh
 */
@Repository
public interface TasteScoreMapper {
    /**
     * 通过大赛Id，小组ID和螃蟹性别来查找某一组某一性别的口感得分平均分
     *
     * @param competitionId
     * @param groupId
     * @param crabMale
     * @return
     */
    Float averageTasteScoreByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, int groupId, int crabMale);

    /**
     * 通过大赛Id，小组ID和螃蟹性别来查找某一组某一性别的口感得分标准差
     *
     * @param competitionId
     * @param groupId
     * @param crabMale
     * @return
     */
    Float sdTasteScoreByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, int groupId, int crabMale);

    /**
     * 通过大赛Id，小组Id和螃蟹性别来查找口感分数信息
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @return 所有符合条件的口感分数信息记录
     */
    List<TasteScore> selectByCompetitionIdAndGroupId(@Param("competitionId") Integer competitionId,
                                                     @Param("groupId") Integer groupId);

    /**
     * 通过大赛Id，小组Id和螃蟹性别来查找口感分数信息
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别，1:雄 2：雌
     * @return 所有符合条件的口感分数信息记录
     */
    List<TasteScore> selectByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
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
    int insert(TasteScore record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 分数记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(TasteScore record);

    /**
     * 通过主键查找
     *
     * @param scoreId 分数id
     * @return 分数记录
     * @mbggenerated
     */
    TasteScore selectByPrimaryKey(Integer scoreId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 分数记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TasteScore record);

    /**
     * 通过主键更新
     *
     * @param record 分数记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(TasteScore record);
}