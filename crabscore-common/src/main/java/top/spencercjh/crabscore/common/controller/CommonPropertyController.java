package top.spencercjh.crabscore.common.controller;

import top.spencercjh.crabscore.common.common.util.ResultUtil;
import top.spencercjh.crabscore.common.common.vo.Result;
import top.spencercjh.crabscore.common.entity.Competition;
import top.spencercjh.crabscore.common.entity.CompetitionConfig;
import top.spencercjh.crabscore.common.entity.User;
import top.spencercjh.crabscore.common.service.CompetitionConfigService;
import top.spencercjh.crabscore.common.service.CompetitionService;
import top.spencercjh.crabscore.common.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author spencercjh
 */
@Log4j2
@RestController
@Api(description = "公共用户组-大赛公共信息接口")
@RequestMapping("/api/common")
public class CommonPropertyController {
    @Value("${qiniu.accessKey}")
    public String accessKey;

    @Value("${qiniu.secretKey}")
    public String secretKey;

    @Value("${qiniu.bucket}")
    public String bucket;

    private final CompetitionConfigService competitionConfigService;
    private final CompetitionService competitionService;
    private final UserService userService;

    @Autowired
    public CommonPropertyController(CompetitionConfigService competitionConfigService, CompetitionService competitionService, UserService userService) {
        this.competitionConfigService = competitionConfigService;
        this.competitionService = competitionService;
        this.userService = userService;
    }

    @GetMapping(value = "/property/competition/present")
    @ApiOperation("查询当前大赛的信息")
    @ApiResponses({@ApiResponse(code = 200, message = "查询当前大赛信息成功"),
            @ApiResponse(code = 500, message = "查询当前大赛信息失败")})
    public Result<Object> presentCompetitionId() {
        CompetitionConfig competitionConfig = this.competitionConfigService.selectByPrimaryKey(1);
        Competition competition = this.competitionService.selectByPrimaryKey(competitionConfig.getCompetitionId());
        return competition.getCompetitionId() > 0 ?
                new ResultUtil<>().setData(competition, "查询当前大赛信息成功") :
                new ResultUtil<>().setErrorMsg("查询当前大赛信息失败");
    }

    @PutMapping(value = "/person/property", consumes = "application/json")
    @ApiOperation("修改用户资料")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    @ApiResponses({@ApiResponse(code = 200, message = "修改用户资料成功"),
            @ApiResponse(code = 500, message = "修改用户资料失败"),
            @ApiResponse(code = 501, message = "UserId为空")})
    public Result<Object> updateUserProperty(@ApiParam("用户信息Json") @RequestBody User user) {
        if (user.getUserId() == null || user.getUserId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "userId为空");
        } else {
            int updateResult = this.userService.updateByPrimaryKeySelective(user);
            return (updateResult <= 0) ? new ResultUtil<>().setErrorMsg("修改资料失败") :
                    new ResultUtil<>().setSuccessMsg("修改资料成功");
        }
    }

    @GetMapping(value = "/qiniu")
    @ApiOperation("查询七牛云秘钥")
    @ApiResponses({@ApiResponse(code = 200, message = "查询七牛云信息成功")})
    public Result<Object> getQiNiuProperty() {
        Map<String, Object> result = new HashMap<>(3);
        result.put("accessKey", accessKey);
        result.put("secretKey", secretKey);
        result.put("bucket", bucket);
        return new ResultUtil<>().setData(result, "查询七牛云信息成功");
    }
}
