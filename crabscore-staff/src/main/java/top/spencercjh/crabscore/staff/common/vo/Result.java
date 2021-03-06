package top.spencercjh.crabscore.staff.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Exrickx
 * 前后端交互数据标准
 */
@Data
public class Result<t> implements Serializable {

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private t result;
}