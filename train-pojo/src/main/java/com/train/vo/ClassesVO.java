package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesVO {

    @ApiModelProperty("期数id")
    private int trainsId;
    @ApiModelProperty("培训标题")
    private String trainsTitle;
    @ApiModelProperty("开班期数")
    private String trainsName;
    @ApiModelProperty("学时")
    private int trainsHour;
    @ApiModelProperty("培训内容")
    private String trainsContent;
    @ApiModelProperty("开班次数")
    private int trainsCount;
    @ApiModelProperty("是否允许报名")
    private boolean isStart;

    @ApiModelProperty("班次id")
    private int trainsClassId;
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    @ApiModelProperty("开班日期")
    private LocalDate startDate;
    @ApiModelProperty("结班日期")
    private LocalDate endDate;
    @ApiModelProperty("报名人数")
    private int count;


}
