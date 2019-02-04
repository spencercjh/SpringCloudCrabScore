package top.spencercjh.crabscore.admin.serviceimpl;

import top.spencercjh.crabscore.admin.dao.CompetitionConfigMapper;
import top.spencercjh.crabscore.admin.entity.CompetitionConfig;
import top.spencercjh.crabscore.admin.service.CompetitionConfigService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 大赛配置接口实现
 *
 * @author spencercjh
 */
@Log4j2
@Service
public class CompetitionConfigServiceImpl implements CompetitionConfigService {

    private final CompetitionConfigMapper competitionConfigMapper;

    @Autowired
    public CompetitionConfigServiceImpl(CompetitionConfigMapper competitionConfigMapper) {
        this.competitionConfigMapper = competitionConfigMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return competitionConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CompetitionConfig record) {
        return competitionConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(CompetitionConfig record) {
        return competitionConfigMapper.insertSelective(record);
    }

    @Override
    public CompetitionConfig selectByPrimaryKey(Integer id) {
        return competitionConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CompetitionConfig record) {
        return competitionConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CompetitionConfig record) {
        return competitionConfigMapper.updateByPrimaryKey(record);
    }
}
