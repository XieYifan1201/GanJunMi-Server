package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学员报名更新DTO
 * 用于更新已报名学员的信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员报名更新信息")
public class SignDTO1 {

    /** 培训期次ID */
    @ApiModelProperty("培训期次id")
    private Integer trainsId;
    
    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private Integer trainClassId;
    
    /** 学员ID */
    @ApiModelProperty("学员id")
    private Long studentId;
    
    /** 学员报名记录ID */
    @ApiModelProperty("学员报名id")
    private Integer studentCertificateId;
    
    /** 回执文件路径 */
    @ApiModelProperty("回执")
    private String receiptPath;
}
