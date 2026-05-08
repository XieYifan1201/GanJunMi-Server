package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 培训班次VO
 * 返回给前端的培训班次信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("培训班次信息")
public class TrainsClassVO {

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
    @ApiModelProperty("报名班次人数")
    private int count;
    
    /** 报名最多人数 */
    @ApiModelProperty("报名最多人数")
    private int amount;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;
}
