package com.train.dto;

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
public class CertificateDTO {

    @ApiModelProperty("证书id")
    private Long id;
    @ApiModelProperty("证书编号")
    private String cerNumber;
    @ApiModelProperty("证书标题")
    private String title;
    @ApiModelProperty("证书开始日期")
    private LocalDate startdate;
    @ApiModelProperty("证书有效期")
    private Double expiredYear;
    @ApiModelProperty("颁证单位")
    private String trainUnit;
    @ApiModelProperty("证书获得人")
    private String name;
    @ApiModelProperty("证书获得人身份证号")
    private String idCard;
    @ApiModelProperty("照片")
    private String image;

}
