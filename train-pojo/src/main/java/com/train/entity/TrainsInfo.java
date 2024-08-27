package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainsInfo {

    @ApiModelProperty("id")
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

}
