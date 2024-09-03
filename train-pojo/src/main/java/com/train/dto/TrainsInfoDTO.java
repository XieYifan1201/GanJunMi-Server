package com.train.dto;

import com.train.entity.TrainsClass;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainsInfoDTO {

    @ApiModelProperty("培训id")
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

    @ApiModelProperty("培训地址")
    private String trainsAddress;
    /*
    @ApiModelProperty("开班信息")
    List<TrainsClassDTO> classInfo;
     */

}
