package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 证书ID信息VO
 * 用于证书查询和验证
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("证书ID信息")
public class CertificateIDInfo {
    
    /** 证书ID */
    @ApiModelProperty("证书ID")
    private Integer id;
    
    /** 证书编号 */
    @ApiModelProperty("证书编号")
    private String certificateNo;
}
