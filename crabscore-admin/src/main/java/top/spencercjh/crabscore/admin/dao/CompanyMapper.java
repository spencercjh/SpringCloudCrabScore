package top.spencercjh.crabscore.admin.dao;

import org.springframework.stereotype.Repository;
import top.spencercjh.crabscore.admin.entity.Company;

import java.util.List;

/**
 * 参选单位数据处理层
 *
 * @author spencercjh
 */
@Repository
public interface CompanyMapper {
    /**
     * 查找所有参选单位
     *
     * @return 所有参选单位记录
     */
    List<Company> selectAllCompany();

    /**
     * 通过主键删除
     *
     * @param companyId 参选单位id
     * @return 删除记录条数
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer companyId);

    /**
     * 通过记录插入
     *
     * @param record 参选单位记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insert(Company record);

    /**
     * 选择性地通过记录插入
     *
     * @param record 参选单位记录
     * @return 插入记录条数
     * @mbggenerated
     */
    int insertSelective(Company record);

    /**
     * 通过主键查找
     *
     * @param companyId 参选单位id
     * @return 参选单位记录
     * @mbggenerated
     */
    Company selectByPrimaryKey(Integer companyId);

    /**
     * 通过主键选择性地更新
     *
     * @param record 参选单位记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * 通过主键更新
     *
     * @param record 参选单位记录
     * @return 更新记录条数
     * @mbggenerated
     */
    int updateByPrimaryKey(Company record);
}