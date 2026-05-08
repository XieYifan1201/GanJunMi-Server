package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 培训班次DTO
 * 用于培训班次信息的传输和处理
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("培训班次信息")
public class TrainsClassDTO {

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
    
    /** 报名最多人数 */
    @ApiModelProperty("报名最多人数")
    private int amount;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;
}
