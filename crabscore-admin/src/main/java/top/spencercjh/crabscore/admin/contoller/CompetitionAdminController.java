package top.spencercjh.crabscore.admin.contoller;

import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.spencercjh.crabscore.admin.common.util.ResultUtil;
import top.spencercjh.crabscore.admin.common.vo.Result;
import top.spencercjh.crabscore.admin.entity.Competition;
import top.spencercjh.crabscore.admin.entity.CompetitionConfig;
import top.spencercjh.crabscore.admin.service.CompetitionConfigService;
import top.spencercjh.crabscore.admin.service.CompetitionService;

import java.util.List;

/**
 * 大赛后台管理接口
 *
 * @author spencercjh
 */
@SuppressWarnings("unused")
@Log4j2
@RestController
@Api(description = "管理员用户组-大赛后台管理接口")
@RequestMapping(value = "/competition", produces = {"application/json;charset=UTF-8"})
public class CompetitionAdminController {
    private final CompetitionConfigService competitionConfigService;
    private final CompetitionService competitionService;

    @Autowired
    public CompetitionAdminController(CompetitionConfigService competitionConfigService, CompetitionService competitionService) {
        this.competitionConfigService = competitionConfigService;
        this.competitionService = competitionService;
    }

    @GetMapping(value = "/competitions")
    @ApiOperation("查询所有大赛")
    @ApiResponses({@ApiResponse(code = 200, message = "查询所有大赛成功"),
            @ApiResponse(code = 201, message = "没有大赛")})
    public Result<Object> allCompetition() {
        List<Competition> competitionList = this.competitionService.selectAllCompetition();
        if (competitionList.size() == 0) {
            return new ResultUtil<>().setSuccessMsg(201, "没有大赛");
        } else {
            return new ResultUtil<>().setData(competitionList, "查询所有大赛成功");
        }
    }

    @PutMapping(value = "/property", consumes = "application/json")
    @ApiOperation("修改大赛资料")
    @ApiImplicitParam(name = "competition", value = "大赛信息", dataType = "Competition")
    @ApiResponses({@ApiResponse(code = 200, message = "修改大赛资料成功"),
            @ApiResponse(code = 500, message = "修改大赛资料失败"),
            @ApiResponse(code = 501, message = "CompetitionId为空")})
    public Result<Object> updateCompetitionProperty(@ApiParam("大赛信息Json") @RequestBody Competition competition) {
        if (competition.getCompetitionId() == null || competition.getCompetitionId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "CompetitionId为空");
        } else {
            return this.competitionService.updateByPrimaryKeySelective(competition) == 0 ?
                    new ResultUtil<>().setErrorMsg("修改大赛资料失败") : new ResultUtil<>().setSuccessMsg(200, "修改大赛资料成功");
        }
    }

    @GetMapping(value = "/present")
    @ApiOperation("查询当前大赛Id")
    @ApiResponses({@ApiResponse(code = 200, message = "查询当前大赛Id成功"),
            @ApiResponse(code = 500, message = "查询当前大赛Id失败")})
    public Result<Object> presentCompetitionId() {
        CompetitionConfig competitionConfig = this.competitionConfigService.selectByPrimaryKey(1);
        return competitionConfig.getCompetitionId() > 0 ?
                new ResultUtil<>().setData(competitionConfig.getCompetitionId(), "查询当前大赛Id成功") :
                new ResultUtil<>().setErrorMsg("查询当前大赛Id失败");
    }

    @PutMapping(value = "/present", consumes = "application/json")
    @ApiOperation("修改当前大赛配置(大赛id)")
    @ApiImplicitParam(name = "competitionConfig", value = "大赛配置", dataType = "CompetitionConfig")
    @ApiResponses({@ApiResponse(code = 200, message = "修改当前大赛配置成功"),
            @ApiResponse(code = 500, message = "修改当前大赛配置失败"),
            @ApiResponse(code = 501, message = "CompetitionId为空")})
    public Result<Object> updatePresentCompetitionId(@ApiParam("大赛配置Json") @RequestBody CompetitionConfig competitionConfig) {
        if (competitionConfig.getId() == null || competitionConfig.getId() <= 0 ||
                competitionConfig.getCompetitionId() == null || competitionConfig.getCompetitionId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "CompetitionId为空");
        } else {
            return this.competitionConfigService.updateByPrimaryKeySelective(competitionConfig) == 0 ?
                    new ResultUtil<>().setErrorMsg("修改当前大赛配置失败") : new ResultUtil<>().setSuccessMsg("修改当前大赛配置成功");
        }
    }
}
