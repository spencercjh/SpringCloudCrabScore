package top.spencercjh.crabscore.admin.contoller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.spencercjh.crabscore.admin.common.util.ResultUtil;
import top.spencercjh.crabscore.admin.common.vo.Result;
import top.spencercjh.crabscore.admin.entity.Company;
import top.spencercjh.crabscore.admin.entity.dto.GroupResult;
import top.spencercjh.crabscore.admin.service.CompanyService;
import top.spencercjh.crabscore.admin.service.GroupService;

import java.util.List;

/**
 * 参选单位后台管理接口
 *
 * @author spencercjh
 */
@SuppressWarnings("unused")
@Log4j2
@RestController
@Api(description = "管理员用户组-参选单位后台管理接口")
@RequestMapping("/company")
public class CompanyAdminController {
    private final CompanyService companyService;
    private final GroupService groupService;

    @Autowired
    public CompanyAdminController(CompanyService companyService, GroupService groupService) {
        this.companyService = companyService;
        this.groupService = groupService;
    }

    @GetMapping(value = "/{companyId}")
    @ApiOperation("查询单个参选单位")
    @ApiResponses({@ApiResponse(code = 200, message = "查找单个参选单位成功"),
            @ApiResponse(code = 501, message = "companyId为空"),
            @ApiResponse(code = 502, message = "查找单个参选单位失败")})
    public Result<Object> singleCompany(@ApiParam(name = "companyId", value = "参选单位Id", type = "Integer")
                                        @PathVariable("companyId") Integer companyId) {
        if (companyId == null || companyId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "companyId为空");
        } else {
            Company company = this.companyService.selectByPrimaryKey(companyId);
            return StrUtil.isNotBlank(company.getCompanyName()) ?
                    (new ResultUtil<>().setData(company, "查找单个参选单位成功")) :
                    (new ResultUtil<>().setErrorMsg(502, "查找单个参选单位失败"));
        }
    }

    @GetMapping(value = "/companies")
    @ApiOperation("查询所有参选单位")
    @ApiResponses({@ApiResponse(code = 200, message = "查询所有参选单位成功"),
            @ApiResponse(code = 201, message = "companyList列表为空")})
    public Result<Object> allCompany(@ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<Company> companyList = this.companyService.selectAllCompany(pageNum, pageSize);
        if (companyList.size() == 0) {
            return new ResultUtil<>().setSuccessMsg(201, "companyList列表为空");
        } else {
            return new ResultUtil<>().setData(companyList, "查询所有参选单位成功");
        }
    }

    @GetMapping(value = "/groups/{competitionId}/{companyId}/{pageNum}/{pageSize}")
    @ApiOperation("查询在某一届大赛中某一参选单位的所有组")
    @ApiResponses({@ApiResponse(code = 200, message = "查询参选单位所有比赛组成功"),
            @ApiResponse(code = 200, message = "查询参选单位所有比赛组成功"),
            @ApiResponse(code = 201, message = "groupList为空"),
            @ApiResponse(code = 501, message = "competitionId为空"),
            @ApiResponse(code = 502, message = "companyId为空")})
    public Result<Object> allGroup(@ApiParam(name = "competitionId", value = "大赛Id", type = "Integer")
                                   @PathVariable("competitionId") Integer competitionId,
                                   @ApiParam(name = "companyId", value = "参选单位Id", type = "Integer")
                                   @PathVariable("companyId") Integer companyId,
                                   @ApiParam(name = "pageNum", value = "页数", type = "Integer", defaultValue = "1")
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @ApiParam(name = "pageSize", value = "页面大小", type = "Integer", defaultValue = "10")
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        if (competitionId == null || competitionId <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "competitionId为空");
        } else if (companyId == null || companyId <= 0) {
            return new ResultUtil<>().setErrorMsg(502, "companyId为空");
        } else {
            List<GroupResult> groupList = this.groupService.selectAllGroupOneCompetitionOneCompany(competitionId, companyId,
                    pageNum, pageSize);
            if (groupList.size() == 0) {
                return new ResultUtil<>().setSuccessMsg(201, "groupList为空");
            } else {
                return new ResultUtil<>().setData(groupList, "查询参选单位所有比赛组成功");
            }
        }
    }

    @PutMapping(value = "/property", consumes = "application/json")
    @ApiOperation("修改参选单位资料")
    @ApiImplicitParam(name = "company", value = "单个参选单位信息", dataType = "Company")
    @ApiResponses({@ApiResponse(code = 200, message = "修改参选单位资料成功"),
            @ApiResponse(code = 500, message = "修改参选单位资料失败"),
            @ApiResponse(code = 501, message = "主键CompanyId为空")})
    public Result<Object> updateCompanyProperty(@ApiParam("参选单位信息Json") @RequestBody Company company) {
        if (company.getCompanyId() == null || company.getCompanyId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "主键CompanyId为空");
        } else {
            int updateResult = this.companyService.updateByPrimaryKeySelective(company);
            return (updateResult <= 0) ? new ResultUtil<>().setErrorMsg("修改参选单位资料失败") :
                    new ResultUtil<>().setSuccessMsg("修改参选单位资料成功");
        }
    }

    @PostMapping(value = "/creation", consumes = "application/json")
    @ApiOperation("创建参选单位")
    @ApiImplicitParam(name = "company", value = "单个参选单位信息", dataType = "Company")
    @ApiResponses({@ApiResponse(code = 200, message = "创建参选单位成功"),
            @ApiResponse(code = 500, message = "创建参选单位失败"),
            @ApiResponse(code = 501, message = "主键CompanyId为空为空")})
    public Result<Object> insertCompanyProperty(@ApiParam("参选单位信息Json") @RequestBody Company company) {
        if (company.getCompanyId() == null || company.getCompanyId() <= 0) {
            return new ResultUtil<>().setErrorMsg(501, "主键CompanyId为空为空");
        } else {
            int updateResult = this.companyService.insertSelective(company);
            return (updateResult <= 0) ? new ResultUtil<>().setErrorMsg("创建参选单位失败") :
                    new ResultUtil<>().setSuccessMsg("创建参选单位成功");
        }
    }

    @DeleteMapping(value = "/{companyId}")
    @ApiOperation("删除参选单位")
    @ApiResponses({@ApiResponse(code = 200, message = "删除参选单位成功"),
            @ApiResponse(code = 500, message = "删除参选单位失败"),
            @ApiResponse(code = 501, message = "companyId为空")})
    public Result<Object> deleteCompany(@ApiParam(name = "companyId", value = "参选单位Id", type = "Integer")
                                        @PathVariable("companyId") Integer companyId) {
        if (companyId == null || companyId <= 0) {
            return new ResultUtil<>().setErrorMsg("companyId为空");
        } else {
            int deleteResult = this.companyService.deleteByPrimaryKey(companyId);
            return (deleteResult <= 0) ? new ResultUtil<>().setErrorMsg("删除参选单位失败") :
                    new ResultUtil<>().setSuccessMsg("删除参选单位成功");
        }
    }
}
