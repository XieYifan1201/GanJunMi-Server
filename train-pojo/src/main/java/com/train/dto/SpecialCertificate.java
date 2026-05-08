package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 特殊证书DTO
 * 用于设置特殊证书内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("特殊证书")
public class SpecialCertificate {

    /** 报名记录ID */
    @ApiModelProperty("报名ID")
    private Integer id;
    
    /** 特殊证书内容 */
    @ApiModelProperty("特殊的证书内容")
    private String content;
}
