package top.spencercjh.crabscore.common.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.spencercjh.crabscore.common.common.CommonConstant;
import top.spencercjh.crabscore.common.common.util.AesUtil;
import top.spencercjh.crabscore.common.common.util.JwtUtil;
import top.spencercjh.crabscore.common.common.util.ResultUtil;
import top.spencercjh.crabscore.common.common.vo.Result;
import top.spencercjh.crabscore.common.dao.UserMapper;
import top.spencercjh.crabscore.common.entity.User;
import top.spencercjh.crabscore.common.service.SecurityService;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static top.spencercjh.crabscore.common.common.util.JwtUtil.parseJWT;

/**
 * @author spencercjh
 */
@Log4j2
@Service
public class SecurityServiceImpl implements SecurityService {
    private final UserMapper userMapper;

    @Autowired
    public SecurityServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result<Object> login(String encryptedJson, byte[] key) {
        String json;
        try {
            json = new String(AesUtil.decrypt(Base64.decodeBase64(encryptedJson), key),
                    StandardCharsets.UTF_8);
        } catch (Exception | Error e) {
            e.printStackTrace();
            return new ResultUtil<>().setErrorMsg(502, "AES解密错误");
        }
        JSONObject jsonObject = JSON.parseObject(json);
        String username;
        String password;
        Integer roleId;
        try {
            username = jsonObject.getString("username");
            password = jsonObject.getString("password");
            roleId = jsonObject.getInteger("roleId");
        } catch (Exception | Error e) {
            e.printStackTrace();
            return new ResultUtil<>().setErrorMsg(503, "明文JSON解析错误");
        }
        User searchResult = this.userMapper.selectByUserName(username);
        if (searchResult == null) {
            return new ResultUtil<>().setErrorMsg(502, "用户名不存在");
        } else if (!searchResult.getRoleId().equals(roleId)) {
            return new ResultUtil<>().setErrorMsg(503, "用户组选择错误");
        } else if (!searchResult.getPassword().equals(password)) {
            return new ResultUtil<>().setErrorMsg(504, "密码错误");
        } else if (searchResult.getUserName().equals(username) &&
                searchResult.getPassword().equals(password) &&
                searchResult.getRoleId().equals(roleId)) {
            Map<String, Object> subject = new HashMap<>(2);
            subject.put("username", username);
            subject.put("roleId", roleId);
            String jwt = JwtUtil.createJWT(String.valueOf(subject.hashCode()), JSON.toJSONString(subject));
            Map<String, Object> result = new HashMap<>(2);
            result.put("jwt", jwt);
            result.put("user", JSON.toJSON(searchResult));
            return new ResultUtil<>().setData(result, "登录成功");
        } else {
            return new ResultUtil<>().setErrorMsg(501, "用户组参数错误");
        }
    }

    @Override
    public Result<Object> verify(String jwt, Integer roleId, HttpServletRequest request) {
        try {
            if (jwt == null) {
                String errorMessage = request.getRemoteAddr() + "试图越界访问（JWT为空）" + request.getRequestURI();
                log.error(errorMessage);
                return new ResultUtil<>().setData(false, errorMessage, 403, false);
            }
            Claims claims = parseJWT(jwt);
            String subjectJson = claims.getSubject();
            JSONObject jsonObject = JSON.parseObject(subjectJson);
            String jwtUserName = jsonObject.getString("username");
            Integer jwtRoleId = jsonObject.getInteger("roleId");
            User searchResult = this.userMapper.selectByUserName(jwtUserName);
            if (searchResult == null) {
                String errorMessage = request.getRemoteAddr() + "试图越界访问（仿冒用户）" + jwtUserName + " IP:" + request.getRequestURI();
                log.error(errorMessage);
                return new ResultUtil<>().setData(false, errorMessage, 403, false);
            } else if (!jwtRoleId.equals(searchResult.getRoleId())) {
                String errorMessage = request.getRemoteAddr() + "试图越界访问（仿冒用户组）" + roleId + " IP:" + request.getRequestURI();
                log.error(errorMessage);
                return new ResultUtil<>().setData(false, errorMessage, 403, false);
            } else if (!claims.get(CommonConstant.MYKEY, String.class).equals(CommonConstant.MYKEY_VALUE)) {
                String errorMessage = request.getRemoteAddr() + "试图越界访问（MYKEY不正确）" + claims.get(CommonConstant.MYKEY, String.class) + " IP:" + request.getRequestURI();
                log.error(errorMessage);
                return new ResultUtil<>().setData(false, errorMessage, 401, false);
            } else if (!jwtRoleId.equals(roleId) && !roleId.equals(CommonConstant.USER_TYPE_COMMON)) {
                String errorMessage = request.getRemoteAddr() + "试图越界访问（数据正常）" + request.getRequestURI();
                log.error(errorMessage);
                return new ResultUtil<>().setData(false, errorMessage, 403, false);
            } else {
                return new ResultUtil<>().setData(true, "访问成功", 200, true);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            String errorMessage = request.getRemoteAddr() + "权限参数为空" + request.getRequestURI();
            log.error(errorMessage);
            return new ResultUtil<>().setData(false, errorMessage, 403, false);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            String errorMessage = request.getRemoteAddr() + "试图越界访问（JWT过期）" + request.getRequestURI();
            log.error(errorMessage);
            return new ResultUtil<>().setData(false, errorMessage, 403, false);
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            e.printStackTrace();
            String errorMessage = request.getRemoteAddr() + "试图越界访问（JWT本身有其他问题）" + request.getRequestURI();
            log.error(errorMessage);
            return new ResultUtil<>().setData(false, errorMessage, 403, false);
        }
    }
}
