package com.train.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainsClass {

    @ApiModelProperty("id")
    private int trainsClassId;
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    @ApiModelProperty("开班日期")
    private LocalDate startDate;
    @ApiModelProperty("结班日期")
    private LocalDate endDate;
    @ApiModelProperty("培训期次id")
    private int trainsInfoId;
    private int count;
    @ApiModelProperty("报名最多人数")
    private int amount;
    @ApiModelProperty("培训地点")
    private String position;

}
