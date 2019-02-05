package top.spencercjh.crabscore.admin.contoller;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.spencercjh.crabscore.admin.common.CommonConstant;
import top.spencercjh.crabscore.admin.common.util.ResultUtil;
import top.spencercjh.crabscore.admin.common.vo.Result;
import top.spencercjh.crabscore.admin.service.CompanyService;
import top.spencercjh.crabscore.admin.service.GroupService;
import top.spencercjh.crabscore.admin.service.ScoreService;

import java.util.Map;

/**
 * @author : spencercjh
 * @date : 2019/1/12 19:34
 */
@SuppressWarnings("unused")
@Log4j2
@RestController
@Api(description = "管理员用户组-大赛结果管理结果")
@RequestMapping("/result")
public class ResultAdminController {
    private final ScoreService scoreService;
    private final CompanyService companyService;
    private final GroupService groupService;
    @Value("${excel_url}")
    private String excelUrl;

    @Autowired
    public ResultAdminController(ScoreService scoreService, CompanyService companyService, GroupService groupService) {
        this.scoreService = scoreService;
        this.companyService = companyService;
        this.groupService = groupService;
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

    @PostMapping("/excel")
    @ApiOperation("生成大赛数据Excel文件")
    @ApiResponses({@ApiResponse(code = 200, message = "生成成功")})
    public Result<Object> sendDataToPythonSever(@ApiParam(name = "competitionId", value = "大赛ID", type = "Integer", defaultValue = "1") @RequestParam Integer competitionId) {
        // fixme 这里请求本地的5000总是Connection refused: connect，请求其他外网网站正常，怀疑是接入了eureka后导致的问题……
        Map<String, Object> allData = scoreService.getExcelData(competitionId);
        HttpResponse httpResponse = HttpUtil.createPost(excelUrl).form(allData).execute();

        if (httpResponse.getStatus() == CommonConstant.SUCCESS) {
            return new ResultUtil<>().setSuccessMsg("生成成功");
        } else {
            return new ResultUtil<>().setErrorMsg("生成失败");
        }
    }
}
