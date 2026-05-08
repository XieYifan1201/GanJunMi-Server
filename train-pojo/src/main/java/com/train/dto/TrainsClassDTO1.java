package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 培训班次DTO（用于班次管理）
 * 用于培训班次的添加和修改操作
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("培训班次信息-管理")
public class TrainsClassDTO1 {
    
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
    
    /** 报名最多人数 */
    @ApiModelProperty("报名最多人数")
    private int amount;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;
}
