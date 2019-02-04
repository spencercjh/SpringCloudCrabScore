package top.spencercjh.crabscore.common.service;

import top.spencercjh.crabscore.common.common.vo.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * JWT校验接口
 *
 * @author spencercjh
 */
public interface SecurityService {
    /**
     * 登陆服务：用户的登陆信息会写进一个JSON串，该串经过AES加密传到后端；这个接口负责解密数据和解析JSON；
     *
     * @param json 包含登陆信息的JSON串
     * @param key  AES秘钥
     * @return 登陆结果
     */
    Result<Object> login(String json, byte[] key);

    /**
     * JWT校验:将JWT串中的用户组信息与利用用户信息查询得到的用户组信息和当前访问的Api允许的用户组信息进行三重比对
     *
     * @param jwt              包含用户信息的JWT串
     * @param requestApiRoleId 当前访问的Api允许的用户组信息
     * @param request          记录IP地址
     * @return 是否符合接口访问要求
     */
    Result<Object> verify(String jwt, Integer requestApiRoleId, HttpServletRequest request);
}