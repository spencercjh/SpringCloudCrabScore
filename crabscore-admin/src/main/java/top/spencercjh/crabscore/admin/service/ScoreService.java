package top.spencercjh.crabscore.admin.service;

import java.util.Map;

/**
 * 肥满度，种质分，平常分计算接口
 *
 * @author spencercjh
 */
public interface ScoreService {

    /**
     * 计算并修改某一届大赛所有组的肥满度评分
     *
     * @param competitionId 大赛Id
     * @param username      updateUser
     * @return 事务结果
     */
    void calculateAllFatnessScore(Integer competitionId, String username);

    /**
     * 计算并修改某一届大赛所有组的种质评分
     *
     * @param competitionId 大赛Id
     * @param username      updateUser
     * @return 事务结果
     */
    void calculateAllQualityScore(Integer competitionId, String username);

    /**
     * 计算并修改某一节大赛所有组的口感评分
     *
     * @param competitionId 大赛Id
     * @param username      updateUser
     * @return 事务结果
     */
    void calculateAllTasteScore(Integer competitionId, String username);

    /**
     * 获取生成Excel需要的所有数据
     *
     * @param competitionId 大赛ID
     * @return HashMap
     */
    Map<String, Object> getExcelData(Integer competitionId);
}
