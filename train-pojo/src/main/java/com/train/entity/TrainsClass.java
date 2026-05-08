package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 培训班次实体类
 * 对应数据库 trains_class 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainsClass {

    /** 培训班次ID */
    @ApiModelProperty("id")
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
    
    /** 培训期次ID */
    @ApiModelProperty("培训期次id")
    private int trainsInfoId;
    
    /** 当前报名人数 */
    private int count;
    
    /** 报名最多人数 */
    @ApiModelProperty("报名最多人数")
    private int amount;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;
}
