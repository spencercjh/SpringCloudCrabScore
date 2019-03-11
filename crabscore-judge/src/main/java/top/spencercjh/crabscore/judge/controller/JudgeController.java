package top.spencercjh.crabscore.judge.controller;

import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.spencercjh.crabscore.judge.common.util.ResultUtil;
import top.spencercjh.crabscore.judge.common.vo.Result;
import top.spencercjh.crabscore.judge.entity.QualityScore;
import top.spencercjh.crabscore.judge.entity.TasteScore;
import top.spencercjh.crabscore.judge.entity.dto.GroupResult;
import top.spencercjh.crabscore.judge.service.GroupService;
import top.spencercjh.crabscore.judge.service.QualityScoreService;
import top.spencercjh.crabscore.judge.service.TasteScoreService;

import java.util.List;

/**
 * 评委评分接口
 *
 * @author spencercjh
 */
@SuppressWarnings("unused")
@Log4j2
@RestController
@Api(description = "评委用户组-评委评分接口")
@RequestMapping(value = "/api/judge", produces = {"application/json;charset=UTF-8"})
public class JudgeController {
    private final GroupService groupService;
    private final QualityScoreService qualityScoreService;
    private final TasteScoreService tasteScoreService;

    @Autowired
    public JudgeController(GroupService groupService, TasteScoreService tasteScoreService, QualityScoreService qualityScoreService) {
        this.groupService = groupService;
        this.tasteScoreService = tasteScoreService;
        this.qualityScoreService = qualityScoreService;
    }

    @GetMapping("/groups/{competitionId}")
    @ApiOperation("查看某一年的所有比赛组")
    @ApiResponses({@ApiResponse(code = 200, message = "查询所有比赛组成功"),
            @ApiResponse(code = 201, message = "groupList为空"),
            @ApiResponse(code = 501, message = "competitionId为空")})
    public Result<Object> allGroup(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                   @PathVariable(value = "competitionId") Integer competitionId,
                                   @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else {
            List<GroupResult> groupList = this.groupService.selectAllGroupOneCompetition(competitionId, pageNum, pageSize);
            if (groupList.size() == 0) {
                return new ResultUtil<>().setSuccessMsg(201, "groupList为空");
            } else {
                return new ResultUtil<>().setData(groupList, "查询所有比赛组成功");
            }
        }
    }

    @GetMapping("/qualities/{competitionId}/{groupId}")
    @ApiOperation("查看某一年的某一组的所有种质得分信息")
    @ApiResponses({@ApiResponse(code = 200, message = "查询所有种质得分信息成功"),
            @ApiResponse(code = 201, message = "qualityScoreList为空"),
            @ApiResponse(code = 501, message = "competitionId为空"),
            @ApiResponse(code = 502, message = "groupId为空")})
    public Result<Object> getOneGroupAllQualityScore(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                                     @PathVariable("competitionId") Integer competitionId,
                                                     @ApiParam(name = "groupId", value = "小组Id", type = "Integer")
                                                     @PathVariable("groupId") Integer groupId,
                                                     @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                     @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else if (groupId == null || groupId <= 0) {
            return new ResultUtil<>().setErrorMsg(502, "groupId为空");
        } else {
            List<QualityScore> qualityScoreList = this.qualityScoreService.selectByCompetitionIdAndGroupId(
                    competitionId, groupId, pageNum, pageSize);
            if (qualityScoreList.size() == 0) {
                return new ResultUtil<>().setSuccessMsg(201, "qualityScoreList为空");
            } else {
                return new ResultUtil<>().setData(qualityScoreList, "查询所有种质得分信息成功");
            }
        }
    }

    @GetMapping("/tastes/{competitionId}/{groupId}")
    @ApiOperation("查看某一年的某一组的所有口感得分信息")
    @ApiResponses({@ApiResponse(code = 200, message = "查询所有口感得分信息成功"),
            @ApiResponse(code = 201, message = "tasteScoreList为空"),
            @ApiResponse(code = 501, message = "competitionId为空"),
            @ApiResponse(code = 502, message = "groupId为空")})
    public Result<Object> getOneGroupAllTasteScore(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                                   @PathVariable("competitionId") Integer competitionId,
                                                   @ApiParam(name = "groupId", value = "小组Id", type = "Integer")
                                                   @PathVariable("groupId") Integer groupId,
                                                   @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                   @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else if (groupId == null || groupId <= 0) {
            return new ResultUtil<>().setErrorMsg(502, "groupId为空");
        } else {
            List<TasteScore> tasteScoreList = this.tasteScoreService.selectByCompetitionIdAndGroupId(
                    competitionId, groupId, pageNum, pageSize);
            if (tasteScoreList.size() == 0) {
                return new ResultUtil<>().setSuccessMsg(201, "tasteScoreList为空");
            } else {
                return new ResultUtil<>().setData(tasteScoreList, "查询所有口感得分信息成功");
            }
        }
    }

    @PostMapping(value = "/quality", consumes = "application/json")
    @ApiOperation("插入种质成绩信息")
    @ApiResponses({@ApiResponse(code = 200, message = "插入种质成绩信息成功"),
            @ApiResponse(code = 500, message = "插入种质成绩信息失败"),
            @ApiResponse(code = 501, message = "ScoreId为空")})
    public Result<Object> insertQualityScoreInfo(@ApiParam(name = "qualityScoreInfo", value = "种质成绩信息Json", type = "QualityScore")
                                                 @RequestBody QualityScore qualityScore) {
        if (qualityScore.getScoreId() == null || qualityScore.getScoreId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "ScoreId为空");
        } else {
            return this.qualityScoreService.insertSelective(qualityScore) <= 0 ?
                    new ResultUtil<>().setErrorMsg("插入种质成绩信息失败") : new ResultUtil<>().setSuccessMsg("插入种质成绩信息成功");
        }
    }

    @PostMapping(value = "/taste", consumes = "application/json")
    @ApiOperation("插入口感成绩信息")
    @ApiResponses({@ApiResponse(code = 200, message = "插入种质成绩信息成功"),
            @ApiResponse(code = 500, message = "插入种质成绩信息失败"),
            @ApiResponse(code = 501, message = "ScoreId为空")})
    public Result<Object> insertTasteScoreInfo(@ApiParam(name = "tasteScoreInfo", value = "口感成绩信息Json", type = "TasteScore")
                                               @RequestBody TasteScore tasteScore) {
        if (tasteScore.getScoreId() == null || tasteScore.getScoreId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "ScoreId为空");
        } else {
            return this.tasteScoreService.insertSelective(tasteScore) <= 0 ?
                    new ResultUtil<>().setErrorMsg("插入口感成绩信息失败") : new ResultUtil<>().setSuccessMsg("插入口感成绩信息成功");
        }
    }

    @PutMapping(value = "/quality", consumes = "application/json")
    @ApiOperation("更新种质成绩信息")
    @ApiResponses({@ApiResponse(code = 200, message = "修改种质成绩信息成功"),
            @ApiResponse(code = 500, message = "修改种质成绩信息失败"),
            @ApiResponse(code = 501, message = "主键ScoreId为空")})
    public Result<Object> updateQualityScoreInfo(@ApiParam(name = "qualityScoreInfo", value = "种质成绩信息Json", type = "QualityScore")
                                                 @RequestBody QualityScore qualityScore) {
        if (qualityScore.getScoreId() == null || qualityScore.getScoreId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "主键ScoreId为空");
        } else {
            int updateResult = this.qualityScoreService.updateByPrimaryKeySelective(qualityScore);
            return (updateResult <= 0) ? new ResultUtil<>().setErrorMsg("修改种质成绩信息失败") :
                    new ResultUtil<>().setSuccessMsg("修改种质成绩信息成功");
        }
    }

    @PutMapping(value = "/taste", consumes = "application/json")
    @ApiOperation("更新口感成绩信息")
    @ApiResponses({@ApiResponse(code = 200, message = "修改口感成绩信息成功"),
            @ApiResponse(code = 500, message = "修改口感成绩信息失败"),
            @ApiResponse(code = 501, message = "主键ScoreId为空")})
    public Result<Object> updateTasteScoreInfo(@ApiParam(name = "tasteScoreInfo", value = "口感成绩信息Json", type = "TasteScore")
                                               @RequestBody TasteScore tasteScore) {
        if (tasteScore.getScoreId() == null || tasteScore.getScoreId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "ScoreId为空");
        } else {
            return this.tasteScoreService.updateByPrimaryKeySelective(tasteScore) <= 0 ?
                    new ResultUtil<>().setErrorMsg("修改口感成绩信息失败") : new ResultUtil<>().setSuccessMsg("修改口感成绩信息成功");
        }
    }
}
