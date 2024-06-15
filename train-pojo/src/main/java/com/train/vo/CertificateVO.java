package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CertificateVO {

    private Long id;        //UsersCertificate主键
    @ApiModelProperty("证书编号")
    private String cerNumber;
    @ApiModelProperty("证书标题")
    private String title;
    @ApiModelProperty("证书开始日期")
    private LocalDateTime startdate;
    @ApiModelProperty("证书有效期")
    private Double expiredYear;
    @ApiModelProperty("颁证单位")
    private String trainUnit;
    @ApiModelProperty("证书获得人")
    private String name;
    @ApiModelProperty("照片")
    private String image;


}
