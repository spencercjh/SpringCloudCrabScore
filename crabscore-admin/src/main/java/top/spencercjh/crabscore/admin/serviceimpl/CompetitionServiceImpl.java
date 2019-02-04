package top.spencercjh.crabscore.admin.serviceimpl;

import top.spencercjh.crabscore.admin.dao.CompetitionMapper;
import top.spencercjh.crabscore.admin.entity.Competition;
import top.spencercjh.crabscore.admin.service.CompetitionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 大赛信息接口实现
 *
 * @author spencercjh
 */
@Log4j2
@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionMapper competitionMapper;

    @Autowired
    public CompetitionServiceImpl(CompetitionMapper competitionMapper) {
        this.competitionMapper = competitionMapper;
    }

    @Override
    public List<Competition> selectAllCompetition() {
        return competitionMapper.selectAllCompetition();
    }

    @Override
    public int deleteByPrimaryKey(Integer competitionId) {
        return competitionMapper.deleteByPrimaryKey(competitionId);
    }

    @Override
    public int insert(Competition record) {
        return competitionMapper.insert(record);
    }

    @Override
    public int insertSelective(Competition record) {
        return competitionMapper.insertSelective(record);
    }

    @Override
    public Competition selectByPrimaryKey(Integer competitionId) {
        return competitionMapper.selectByPrimaryKey(competitionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Competition record) {
        return competitionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Competition record) {
        return competitionMapper.updateByPrimaryKey(record);
    }
}
