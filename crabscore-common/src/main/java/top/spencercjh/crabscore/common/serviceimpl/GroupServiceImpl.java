package top.spencercjh.crabscore.common.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.spencercjh.crabscore.common.dao.GroupMapper;
import top.spencercjh.crabscore.common.entity.Group;
import top.spencercjh.crabscore.common.entity.dto.GroupResult;
import top.spencercjh.crabscore.common.entity.dto.RankResult;
import top.spencercjh.crabscore.common.service.GroupService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 小组接口实现
 *
 * @author spencercjh
 */
@Log4j2
@Service
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public List<GroupResult> selectAllGroupOneCompetition(Integer competitionId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return groupMapper.selectAllGroupOneCompetition(competitionId);
    }

    @Override
    public PageInfo<RankResult> selectAllGroupOneCompetitionOrderByQualityScore(Integer competitionId, int pageNum, int pageSize) {
        Page<RankResult> page = PageHelper.startPage(pageNum, pageSize);
        groupMapper.selectAllGroupOneCompetitionOrderByQualityScore(competitionId);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<RankResult> selectAllGroupOneCompetitionOrderByTasteScore(Integer competitionId, int pageNum, int pageSize) {
        Page<RankResult> page = PageHelper.startPage(pageNum, pageSize);
        groupMapper.selectAllGroupOneCompetitionOrderByTasteScore(competitionId);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<RankResult> selectAllGroupOneCompetitionOrderByFatnessScore(Integer competitionId, int pageNum, int pageSize) {
        Page<RankResult> page = PageHelper.startPage(pageNum, pageSize);
        groupMapper.selectAllGroupOneCompetitionOrderByFatnessScore(competitionId);
        return page.toPageInfo();
    }

    @Override
    public List<GroupResult> selectAllGroupOneCompetitionOneCompany(Integer competitionId, Integer companyId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return groupMapper.selectAllGroupOneCompetitionOneCompany(competitionId, companyId);
    }

    @Override
    public int deleteByPrimaryKey(Integer groupId) {
        return groupMapper.deleteByPrimaryKey(groupId);
    }

    @Override
    public int insert(Group record) {
        return groupMapper.insert(record);
    }

    @Override
    public int insertSelective(Group record) {
        return groupMapper.insertSelective(record);
    }

    @Override
    public Group selectByPrimaryKey(Integer groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public int updateByPrimaryKeySelective(Group record) {
        return groupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Group record) {
        return groupMapper.updateByPrimaryKey(record);
    }
}
