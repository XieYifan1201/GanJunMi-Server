package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainsClassDTO1 {
    @ApiModelProperty("班次id")
    private int trainsClassId;
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    @ApiModelProperty("开班日期")
    private LocalDate startDate;
    @ApiModelProperty("结班日期")
    private LocalDate endDate;
}
