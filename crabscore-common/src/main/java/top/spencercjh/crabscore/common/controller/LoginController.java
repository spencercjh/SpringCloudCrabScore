package top.spencercjh.crabscore.common.controller;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import top.spencercjh.crabscore.common.common.CommonConstant;
import top.spencercjh.crabscore.common.common.util.JwtUtil;
import top.spencercjh.crabscore.common.common.util.MessageUtil;
import top.spencercjh.crabscore.common.common.util.ResultUtil;
import top.spencercjh.crabscore.common.common.util.UsernameUtil;
import top.spencercjh.crabscore.common.common.vo.Result;
import top.spencercjh.crabscore.common.entity.User;
import top.spencercjh.crabscore.common.service.SecurityService;
import top.spencercjh.crabscore.common.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户相关接口
 *
 * @author spencercjh
 */
@Log4j2
@RestController
@Api(description = "公共用户组-登录相关接口")
@RequestMapping("/api/common")
public class LoginController {
    private final UserService userService;
    private final MessageUtil messageUtil;
    private final SecurityService securityService;

    @Autowired
    public LoginController(UserService userService, MessageUtil messageUtil, SecurityService securityService) {
        this.userService = userService;
        this.messageUtil = messageUtil;
        this.securityService = securityService;
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录,这个接口会在body里返回JWT！！！", notes = "参数检查交给Android端完成")
    @ApiResponses({@ApiResponse(code = 200, message = "登录成功"),
            @ApiResponse(code = 501, message = "用户组参数错误"),
            @ApiResponse(code = 502, message = "用户名不存在"),
            @ApiResponse(code = 503, message = "用户组选择错误"),
            @ApiResponse(code = 504, message = "密码错误")})
    public Result<Object> login(@ApiParam(name = "json", value = "加密后的JSON串", type = "String")
                                @RequestParam("json") String json,
                                @ApiParam(name = "key", value = "秘钥JSON", type = "String")
                                @RequestParam("key") String keyList) {
        byte[] key = new byte[16];
        int i = 0;
        JSONArray jsonArray = JSON.parseArray(keyList);
        for (Object object : jsonArray) {
            key[i++] = (byte) (((Integer) (object)).intValue());
        }
        return this.securityService.login(json, key);
    }

    @PostMapping("/creation")
    @ApiOperation(value = "用户注册", notes = "参数检查交给Android端完成")
    @ApiResponses({@ApiResponse(code = 200, message = "注册成功"),
            @ApiResponse(code = 500, message = "注册失败"),
            @ApiResponse(code = 501, message = "用户名已存在")})
    public Result<Object> register(@ApiParam(name = "username", value = "用户名", type = "String") @RequestParam String username,
                                   @ApiParam(name = "password", value = "密码", type = "String") @RequestParam String password,
                                   @ApiParam(name = "roleId", value = "用户组", type = "Integer") @RequestParam Integer roleId,
                                   @ApiParam(name = "email", value = "邮箱(其实是手机)", type = "String") @RequestParam String email,
                                   @ApiParam(name = "displayName", value = "显示名", type = "String") @RequestParam String displayName) {
        User searchResult = this.userService.selectByUserName(username);
        if (searchResult == null) {
            User newUser = new User(username, password, displayName, roleId, CommonConstant.USER_STATUS_LOCK, email,
                    CommonConstant.USER_COMPETITION_ALL, new Date(System.currentTimeMillis()), username,
                    new Date(System.currentTimeMillis()), username);
            int insertResult = this.userService.insertSelective(newUser);
            return insertResult > 0 ? new ResultUtil<>().setSuccessMsg("注册成功") : new ResultUtil<>().setErrorMsg("注册失败");
        } else {
            return new ResultUtil<>().setErrorMsg(501, "用户名已存在");
        }
    }

    @SuppressWarnings("Duplicates")
    @GetMapping("/code")
    @ApiOperation(value = "请求发送验证码短信")
    @ApiResponses({@ApiResponse(code = 200, message = "验证码发送成功"),
            @ApiResponse(code = 500, message = "验证码发送失败"),
            @ApiResponse(code = 501, message = "手机号格式有误")})
    public Result<Object> sendCode(@ApiParam(name = "mobile", value = "手机号", type = "String") @RequestParam String mobile) {
        if (UsernameUtil.mobile(mobile)) {
            try {
                if (messageUtil.sendCode(mobile)) {
                    return new ResultUtil<>().setSuccessMsg("验证码发送成功");
                } else {
                    return new ResultUtil<>().setErrorMsg("验证码发送失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("短信发送请求错误");
                return new ResultUtil<>().setErrorMsg("验证码发送失败");
            }
        } else {
            return new ResultUtil<>().setErrorMsg(501, "手机号格式有误");
        }
    }

    @SuppressWarnings("Duplicates")
    @PostMapping("/code")
    @ApiOperation(value = "请求校验验证码")
    @ApiResponses({@ApiResponse(code = 200, message = "验证码校验成功"),
            @ApiResponse(code = 501, message = "手机号或验证码格式有误"),
            @ApiResponse(code = 502, message = "验证码无效"),
            @ApiResponse(code = 500, message = "验证码校验失败")})
    public Result<Object> verifyCode(@ApiParam(name = "mobile", value = "手机号", type = "String") @RequestParam String mobile,
                                     @ApiParam(name = "code", value = "验证码", type = "String") @RequestParam String code) {
        if (UsernameUtil.mobile(mobile) && NumberUtil.isNumber(code)) {
            try {
                if (messageUtil.verifyCode(mobile, code)) {
                    return new ResultUtil<>().setSuccessMsg("验证码校验成功");
                } else {
                    return new ResultUtil<>().setErrorMsg(502, "验证码无效");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultUtil<>().setErrorMsg(500, "验证码校验失败");
            }
        } else {
            return new ResultUtil<>().setErrorMsg(501, "手机号或验证码格式有误");
        }
    }

    @PostMapping("/direct")
    @ApiOperation(value = "输入手机号直接登陆或者注册，注册完自动完成登陆，这个接口会在body里返回JWT！！！")
    @ApiResponses({@ApiResponse(code = 200, message = "直接登陆成功（新注册用户）/直接登陆成功（老用户）"),
            @ApiResponse(code = 500, message = "直接登陆失败（新用户注册失败）"),
            @ApiResponse(code = 501, message = "手机号有误")})
    public Result<Object> directLogin(@ApiParam(name = "mobile", value = "手机号", type = "String") @RequestParam String mobile) {
        if (UsernameUtil.mobile(mobile)) {
            User searchResult = this.userService.selectByUserName(mobile);
            if (searchResult == null) {
                String password = new String(Hex.encodeHex(DigestUtils.md5(mobile))).toUpperCase();
                User newUser = new User(mobile, password,
                        "用户" + mobile, CommonConstant.USER_TYPE_COMPANY, CommonConstant.USER_STATUS_LOCK, mobile,
                        CommonConstant.USER_COMPETITION_ALL, new Date(System.currentTimeMillis()), mobile,
                        new Date(System.currentTimeMillis()), mobile);
                int insertResult = this.userService.insertSelective(newUser);
                if (insertResult > 0) {
                    Map<String, Object> subject = new HashMap<>(2);
                    subject.put("username", mobile);
                    subject.put("roleId", CommonConstant.USER_TYPE_COMPANY);
                    String jwt = JwtUtil.createJWT(String.valueOf(subject.hashCode()), JSON.toJSONString(subject));
                    Map<String, Object> result = new HashMap<>(2);
                    result.put("jwt", jwt);
                    result.put("roleId", CommonConstant.USER_TYPE_COMPANY);
                    return new ResultUtil<>().setData(result, "直接登陆成功（新注册用户）");
                } else {
                    return new ResultUtil<>().setErrorMsg(500, "直接注册失败");
                }
            } else {
                Map<String, Object> subject = new HashMap<>(2);
                subject.put("username", searchResult.getUserName());
                subject.put("roleId", searchResult.getRoleId());
                String jwt = JwtUtil.createJWT(String.valueOf(subject.hashCode()), JSON.toJSONString(subject));
                Map<String, Object> result = new HashMap<>(2);
                result.put("jwt", jwt);
                result.put("roleId", searchResult.getRoleId());
                return new ResultUtil<>().setData(result, "直接登陆成功（老用户）");
            }
        } else {
            return new ResultUtil<>().setErrorMsg(501, "手机号有误");
        }
    }

    @PutMapping("/password")
    @ApiResponses({@ApiResponse(code = 200, message = "修改密码成功"),
            @ApiResponse(code = 500, message = "没有对应的用户"),
            @ApiResponse(code = 501, message = "修改密码失败")})
    @ApiOperation(value = "忘记密码的用户通过手机号校验后修改自己的密码")
    public Result<Object> forgetPassword(@ApiParam(name = "mobile", value = "手机号", type = "String") @RequestParam String mobile,
                                         @ApiParam(name = "newPassword", value = "新密码", type = "String") @RequestParam String password) {
        User searchResult = this.userService.selectByUserName(mobile);
        if (searchResult == null) {
            return new ResultUtil<>().setErrorMsg(500, "没有对应的用户");
        } else {
            searchResult.setPassword(password);
            searchResult.setUpdateUser(searchResult.getUserName());
            searchResult.setUpdateDate(new Date(System.currentTimeMillis()));
            int updateResult = this.userService.updateByPrimaryKeySelective(searchResult);
            if (updateResult <= 0) {
                return new ResultUtil<>().setErrorMsg(501, "修改密码失败");
            } else {
                return new ResultUtil<>().setSuccessMsg("修改密码成功");
            }
        }
    }
}