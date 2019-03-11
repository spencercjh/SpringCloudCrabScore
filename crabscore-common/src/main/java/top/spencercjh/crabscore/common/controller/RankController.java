package top.spencercjh.crabscore.common.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.spencercjh.crabscore.common.common.util.ResultUtil;
import top.spencercjh.crabscore.common.common.vo.Result;
import top.spencercjh.crabscore.common.entity.dto.RankResult;
import top.spencercjh.crabscore.common.service.GroupService;

/**
 * 公共三大奖查分接口
 *
 * @author spencercjh
 */
@Log4j2
@RestController
@Api(description = "公共用户组-公共三大奖查分接口")
@RequestMapping(value = "/score", produces = {"application/json;charset=UTF-8"})
public class RankController {
    private final GroupService groupService;

    @Autowired
    public RankController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "/fatness/competition/{competitionId}")
    @ApiOperation(value = "查询金蟹奖成绩", notes = "已在SQL中按照从大到小顺序排列")
    @ApiResponses({@ApiResponse(code = 200, message = "查找所有金蟹奖成绩成功"),
            @ApiResponse(code = 201, message = "没有金蟹奖成绩相关成绩"),
            @ApiResponse(code = 501, message = "competitionId为空")})
    public Result<Object> fatnessPrize(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                       @PathVariable("competitionId") Integer competitionId,
                                       @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else {
            PageInfo<RankResult> pageInfo = groupService.selectAllGroupOneCompetitionOrderByFatnessScore(competitionId,
                    pageNum, pageSize);
            return pageInfo.getList().isEmpty() ? (new ResultUtil<>().setSuccessMsg(201, "没有金蟹奖成绩")) :
                    (new ResultUtil<>().setData(pageInfo, "查找所有金蟹奖成绩成功"));
        }
    }

    @GetMapping(value = "/qualities/competition/{competitionId}")
    @ApiOperation(value = "查询种质奖成绩", notes = "已在SQL中按照从大到小顺序排列")
    @ApiResponses({@ApiResponse(code = 200, message = "查找所有种质奖成绩成功"),
            @ApiResponse(code = 201, message = "没有种质奖成绩"),
            @ApiResponse(code = 501, message = "competitionId为空")})
    public Result<Object> qualityPrize(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                       @PathVariable("competitionId") Integer competitionId,
                                       @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else {
            PageInfo<RankResult> pageInfo = groupService.selectAllGroupOneCompetitionOrderByQualityScore(competitionId,
                    pageNum, pageSize);
            return pageInfo.getList().isEmpty() ? (new ResultUtil<>().setSuccessMsg(201, "没有种质奖成绩")) :
                    (new ResultUtil<>().setData(pageInfo, "查找所有种质奖成绩成功"));
        }
    }

    @GetMapping(value = "/tastes/competition/{competitionId}")
    @ApiOperation(value = "查询口感奖成绩", notes = "已在SQL中按照从大到小顺序排列")
    @ApiResponses({@ApiResponse(code = 200, message = "查找所有口感奖成绩成功"),
            @ApiResponse(code = 201, message = "没有口感奖成绩"),
            @ApiResponse(code = 501, message = "competitionId为空")})
    public Result<Object> tastePrize(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                     @PathVariable("competitionId") Integer competitionId,
                                     @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else {
            PageInfo<RankResult> pageInfo = groupService.selectAllGroupOneCompetitionOrderByTasteScore(competitionId,
                    pageNum, pageSize);
            return pageInfo.getList().isEmpty() ? (new ResultUtil<>().setSuccessMsg(201, "没有口感奖成绩")) :
                    (new ResultUtil<>().setData(pageInfo, "查找所有口感奖成绩成功"));
        }
    }
}
