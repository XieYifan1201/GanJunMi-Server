package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 培训班次VO
 * 返回给前端的培训班次详细信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("培训班次信息")
public class ClassesVO {

    /** 培训期次ID */
    @ApiModelProperty("期数id")
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

    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private int trainsClassId;
    
    /** 培训班次名称 */
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    
    /** 开班日期 */
    @ApiModelProperty("开班日期")
    private LocalDate startDate;
    
    /** 结班日期 */
    @ApiModelProperty("结班日期")
    private LocalDate endDate;
    
    /** 当前报名人数 */
    @ApiModelProperty("报名人数")
    private int count;
    
    /** 报名最多人数 */
    @ApiModelProperty("报名最多人数")
    private int amount;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;
}
