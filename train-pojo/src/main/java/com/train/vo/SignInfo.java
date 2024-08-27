package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SignInfo {
    @ApiModelProperty("是否颁发证书")
    private boolean isCertificate;
    @ApiModelProperty("培训班标题")
    private String trainsTitle;
    @ApiModelProperty("开班期数")
    private String trainsName;
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    @ApiModelProperty("培训开始日期")
    private LocalDate startDate;
    @ApiModelProperty("培训结束日期")
    private LocalDate endDate;
    @ApiModelProperty("证书编号")
    private String CertificateNo;

}
