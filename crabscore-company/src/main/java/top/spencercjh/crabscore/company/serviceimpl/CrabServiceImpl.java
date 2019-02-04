package top.spencercjh.crabscore.company.serviceimpl;

import com.github.pagehelper.PageHelper;
import top.spencercjh.crabscore.company.dao.CrabMapper;
import top.spencercjh.crabscore.company.entity.Crab;
import top.spencercjh.crabscore.company.entity.QualityScore;
import top.spencercjh.crabscore.company.entity.TasteScore;
import top.spencercjh.crabscore.company.entity.dto.CrabResult;
import top.spencercjh.crabscore.company.entity.dto.CrabScoreResult;
import top.spencercjh.crabscore.company.service.CrabService;
import top.spencercjh.crabscore.company.service.QualityScoreService;
import top.spencercjh.crabscore.company.service.TasteScoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 螃蟹接口实现
 *
 * @author spencercjh
 */
@Log4j2
@Service
public class CrabServiceImpl implements CrabService {

    private final CrabMapper crabMapper;
    private final TasteScoreService tasteScoreService;
    private final QualityScoreService qualityScoreService;

    @Autowired
    public CrabServiceImpl(CrabMapper crabMapper, TasteScoreService tasteScoreService, QualityScoreService qualityScoreService) {
        this.crabMapper = crabMapper;
        this.tasteScoreService = tasteScoreService;
        this.qualityScoreService = qualityScoreService;
    }

    @Override
    public boolean insertCrabAttachScoreInfo(Crab crab) {
        TasteScore tasteScore = new TasteScore();
        tasteScore.setCrabId(crab.getCrabId());
        tasteScore.setGroupId(crab.getGroupId());
        tasteScore.setCrabSex(crab.getCrabSex());
        tasteScore.setCompetitionId(crab.getCompetitionId());
        tasteScore.setCreateDate(new Date(System.currentTimeMillis()));
        tasteScore.setUpdateDate(new Date(System.currentTimeMillis()));
        tasteScore.setCreateUser(crab.getCreateUser());
        tasteScore.setUpdateUser(crab.getUpdateUser());
        int resultInsertTasteScore = tasteScoreService.insertSelective(tasteScore);
        QualityScore qualityScore = new QualityScore();
        qualityScore.setCrabId(crab.getCrabId());
        qualityScore.setGroupId(crab.getGroupId());
        qualityScore.setCrabSex(crab.getCrabSex());
        qualityScore.setCompetitionId(crab.getCompetitionId());
        qualityScore.setCreateDate(new Date(System.currentTimeMillis()));
        qualityScore.setUpdateDate(new Date(System.currentTimeMillis()));
        qualityScore.setCreateUser(crab.getCreateUser());
        qualityScore.setUpdateUser(crab.getUpdateUser());
        int resultInsertQualityScore = qualityScoreService.insertSelective(qualityScore);
        return resultInsertQualityScore > 0 && resultInsertTasteScore > 0;
    }

    @Override
    public List<CrabScoreResult> selectOneGroupAllCrabAndScore(Integer competitionId, Integer groupId,
                                                               int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return crabMapper.selectOneGroupAllCrabAndScore(competitionId, groupId);
    }

    @Override
    public Float sdFatnessByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, Integer groupId, Integer crabSex) {
        return crabMapper.sdFatnessByCompetitionIdAndGroupIdAndCrabSex(competitionId, groupId, crabSex);
    }

    @Override
    public Float sdWeightByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, Integer groupId, Integer crabSex) {
        return crabMapper.sdWeightByCompetitionIdAndGroupIdAndCrabSex(competitionId, groupId, crabSex);
    }

    @Override
    public Float averageFatnessByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, Integer groupId, Integer crabSex) {
        return crabMapper.averageFatnessByCompetitionIdAndGroupIdAndCrabSex(competitionId, groupId, crabSex);
    }

    @Override
    public Float averageWeightByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, Integer groupId, Integer crabSex) {
        return crabMapper.averageWeightByCompetitionIdAndGroupIdAndCrabSex(competitionId, groupId, crabSex);
    }

    @Override
    public int updateCrabFatness(Integer competitionId, Float varFatnessM, Float varFatnessF) {
        return crabMapper.updateCrabFatness(competitionId, varFatnessM, varFatnessF);
    }

    @Override
    public CrabResult selectByLabel(String label) {
        return crabMapper.selectByLabel(label);
    }

    @Override
    public List<Crab> selectByCompetitionIdAndGroupIdAndCrabSex(Integer competitionId, Integer groupId, Integer crabSex,
                                                                int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return crabMapper.selectByCompetitionIdAndGroupIdAndCrabSex(competitionId, groupId, crabSex);
    }

    @CacheEvict(key = "#crabId")
    @Override
    public int deleteByPrimaryKey(Integer crabId) {
        return crabMapper.deleteByPrimaryKey(crabId);
    }

    @Override
    public int insert(Crab record) {
        return crabMapper.insert(record);
    }

    @Override
    public int insertSelective(Crab record) {
        return crabMapper.insertSelective(record);
    }

    @Override
    public Crab selectByPrimaryKey(Integer crabId) {
        return crabMapper.selectByPrimaryKey(crabId);
    }

    @Override
    public int updateByPrimaryKeySelective(Crab record) {
        return crabMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Crab record) {
        return crabMapper.updateByPrimaryKey(record);
    }
}
