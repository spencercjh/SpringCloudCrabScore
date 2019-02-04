package top.spencercjh.crabscore.staff.common;

/**
 * @author spencercjh
 */
public interface CommonConstant {
    int CRAB_MALE = 1;

    int CRAB_FEMALE = 0;
    /**
     * 成功
     */
    int SUCCESS = 200;
    /**
     * JWT中自定义校验值的变量名
     */
    String MYKEY = "MYKEY";
    /**
     * JWT中自定义校验值
     */
    String MYKEY_VALUE = "mykeymCPuT5IHaZ628q5f91Ok5Sv13f1bfh5z";
    /**
     * 全部大赛 0
     */
    int USER_COMPETITION_ALL = 0;
    /**
     * JWT过期时间 30分钟
     */
    Long TTLMILLIS = 1800000L;
    /**
     * 用户默认头像
     */
    String USER_DEFAULT_AVATAR = "";

    /**
     * 用户正常状态
     */
    int USER_STATUS_NORMAL = 1;

    /**
     * 用户禁用状态
     */
    int USER_STATUS_LOCK = 0;

    /**
     * 普通用户
     */
    int USER_TYPE_NORMAL = 0;

    String PERSON_CENTER = "person";

    /**
     * 公共权限
     */
    int USER_TYPE_COMMON = 999;
    /**
     * 管理员
     */
    int USER_TYPE_ADMIN = 1;

    String ADMIN = "admin";
    /**
     * 评委
     */
    int USER_TYPE_JUDGE = 2;

    String JUDGE = "judge";
    /**
     * 工作人员
     */
    int USER_TYPE_STAFF = 3;

    String STAFF = "staff";
    /**
     * 参选单位
     */
    int USER_TYPE_COMPANY = 4;

    String COMPANY = "company";
}
