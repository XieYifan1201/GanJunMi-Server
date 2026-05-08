package com.train.dto;

import com.train.entity.TrainsClass;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 培训信息DTO
 * 用于培训信息的传输和处理
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("培训信息")
public class TrainsInfoDTO {

    /** 培训信息ID */
    @ApiModelProperty("培训id")
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
    
    /** 培训班次列表（预留字段） */
    /*
    @ApiModelProperty("开班信息")
    List<TrainsClassDTO> classInfo;
     */
}
