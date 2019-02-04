package top.spencercjh.crabscore.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.spencercjh.crabscore.admin.entity.Crab;
import top.spencercjh.crabscore.admin.entity.dto.CrabResult;
import top.spencercjh.crabscore.admin.entity.dto.CrabScoreResult;

import java.util.List;

/**
 * 螃蟹数据层
 *
 * @author spencercjh
 */
@Repository
public interface CrabMapper {
    /**
     * 查找一个组的所有螃蟹和螃蟹对应的评分
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @return List<CrabScoreResult>
     */
    List<CrabScoreResult> selectOneGroupAllCrabAndScore(@Param("competitionId") Integer competitionId,
                                                        @Param("groupId") Integer groupId);

    /**
     * 计算某一年大赛的某一组的某一性别的螃蟹的肥满度标准差
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别 1雄 2雌
     * @return 肥满度标准差
     */
    Float sdFatnessByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                       @Param("groupId") Integer groupId,
                                                       @Param("crabSex") Integer crabSex);

    /**
     * 计算某一年大赛的某一组的某一性别的螃蟹的体重标准差
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别 1雄 2雌
     * @return 体重标准差
     */
    Float sdWeightByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                      @Param("groupId") Integer groupId,
                                                      @Param("crabSex") Integer crabSex);

    /**
     * 计算某一年大赛的某一组的某一性别螃蟹的平均肥满度
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别 1雄 2雌
     * @return 平均肥满度
     */
    Float averageFatnessByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                            @Param("groupId") Integer groupId,
                                                            @Param("crabSex") Integer crabSex);

    /**
     * 计算某一年大赛的某一组的某一性别螃蟹的平均体重
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别 1雄 2雌
     * @return 平均体重
     */
    Float averageWeightByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                           @Param("groupId") Integer groupId,
                                                           @Param("crabSex") Integer crabSex);

    /**
     * 按照计算公式，修改某一年全部螃蟹的肥满度
     *
     * @param competitionId 大赛Id
     * @param varFatnessM   雄蟹肥满度参数
     * @param varFatnessF   雌蟹肥满度参数
     * @return 修改记录条数
     */
    int updateCrabFatness(@Param("competitionId") Integer competitionId,
                          @Param("varFatnessM") Float varFatnessM,
                          @Param("varFatnessF") Float varFatnessF);

    /**
     * 根据唯一标签来查找螃蟹信息
     *
     * @param crabLabel 标签
     * @return 螃蟹信息记录
     */
    CrabResult selectByLabel(@Param("crabLabel") String crabLabel);

    /**
     * 根据大赛Id,小组Id和螃蟹性别来查询螃蟹信息
     *
     * @param competitionId 大赛Id
     * @param groupId       小组Id
     * @param crabSex       性别，1:雄 2：雌
     * @return 所有符合条件的螃蟹信息记录
     */
    List<Crab> selectByCompetitionIdAndGroupIdAndCrabSex(@Param("competitionId") Integer competitionId,
                                                         @Param("groupId") Integer groupId,
                                                         @Param("crabSex") Integer crabSex);

    /**
     * 通过主键删除
     *
     * @param crabId 螃蟹id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer crabId);

    /**
     * 通过记录插入
     *
     * @param record 螃蟹记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(Crab record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 螃蟹记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(Crab record);

    /**
     * 通过主键查找
     *
     * @param crabId 螃蟹id
     * @return 螃蟹记录
     * @mbggenerated
     */
    Crab selectByPrimaryKey(Integer crabId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 螃蟹记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Crab record);

    /**
     * 通过主键更新
     *
     * @param record 螃蟹记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(Crab record);
}