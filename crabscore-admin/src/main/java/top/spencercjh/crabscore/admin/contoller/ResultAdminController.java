package top.spencercjh.crabscore.admin.contoller;

import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.spencercjh.crabscore.admin.common.util.ResultUtil;
import top.spencercjh.crabscore.admin.common.vo.Result;
import top.spencercjh.crabscore.admin.service.ScoreService;

/**
 * @author : spencercjh
 * @date : 2019/1/12 19:34
 */
@SuppressWarnings("unused")
@Log4j2
@RestController
@Api(description = "管理员用户组-大赛结果管理结果")
@RequestMapping(value = "/result", produces = {"application/json;charset=UTF-8"})
public class ResultAdminController {
    private final ScoreService scoreService;

    @Autowired
    public ResultAdminController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping(value = "/calculate")
    @ApiOperation("计算大赛成绩")
    @ApiResponses({@ApiResponse(code = 200, message = "计算成功")})
    public Result<Object> calculatePresentCompetitionScore(@ApiParam(name = "competitionId", value = "大赛ID", type = "Integer") @RequestParam Integer competitionId,
                                                           @ApiParam(name = "username", value = "用户名", type = "String") @RequestParam String username) {
        try {
            scoreService.calculateAllFatnessScore(competitionId, username);

            scoreService.calculateAllQualityScore(competitionId, username);
            scoreService.calculateAllTasteScore(competitionId, username);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultUtil<>().setErrorMsg("成绩计算请求失败");
        }
        return new ResultUtil<>().setSuccessMsg("成绩计算请求成功，请稍后查看成绩");
    }
}
