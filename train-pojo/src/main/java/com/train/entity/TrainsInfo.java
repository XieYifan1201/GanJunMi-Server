package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 培训信息实体类
 * 对应数据库 trains_info 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainsInfo {

    /** 培训信息ID */
    @ApiModelProperty("id")
    private int trainsId;
    
    /** 培训标题 */
    @ApiModelProperty("培训标题")
    private String trainsTitle;
    
    /** 开班期数 */
    @ApiModelProperty("开班期数")
    private String trainsName;
    
    /** 学时 */
    @ApiModelProperty("学时")
    private int trainsHour;
    
    /** 培训内容 */
    @ApiModelProperty("培训内容")
    private String trainsContent;
    
    /** 开班次数 */
    @ApiModelProperty("开班次数")
    private int trainsCount;
    
    /** 是否允许报名 */
    @ApiModelProperty("是否允许报名")
    private boolean isStart;

    /** 培训地址 */
    @ApiModelProperty("培训地址")
    private String trainsAddress;
}
