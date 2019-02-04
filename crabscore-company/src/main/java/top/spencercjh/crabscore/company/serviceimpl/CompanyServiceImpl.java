package top.spencercjh.crabscore.company.serviceimpl;

import com.github.pagehelper.PageHelper;
import top.spencercjh.crabscore.company.dao.CompanyMapper;
import top.spencercjh.crabscore.company.entity.Company;
import top.spencercjh.crabscore.company.service.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 参选单位接口实现
 *
 * @author spencercjh
 */
@Log4j2
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public List<Company> selectAllCompany() {
        return companyMapper.selectAllCompany();
    }

    @Override
    public List<Company> selectAllCompany(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return companyMapper.selectAllCompany();
    }

    @Override
    public int deleteByPrimaryKey(Integer companyId) {
        return companyMapper.deleteByPrimaryKey(companyId);
    }

    @Override
    public int insert(Company record) {
        return companyMapper.insert(record);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Integer companyId) {
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }
}
