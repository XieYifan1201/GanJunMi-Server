package com.train.vo;

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
public class CertificateVO {

    @ApiModelProperty("证书编号")
    private String CertificateNo;
    @ApiModelProperty("证书标题")
    private String title;
    @ApiModelProperty("证书有效开始日期")
    private LocalDate startDate;
    @ApiModelProperty("证书有效年限")
    private String deadline;
    @ApiModelProperty("颁证单位")
    private String trainUnit;
    @ApiModelProperty("证书获得人")
    private String name;
    @ApiModelProperty("证书二维码")
    private String QRcode;
    @ApiModelProperty("照片")
    private String image;
    @ApiModelProperty("培训开始日期")
    private LocalDate trainStartDate;
    @ApiModelProperty("培训结束日期")
    private LocalDate trainEndDate;
    @ApiModelProperty("培训班名称")
    private String trainsTitle;
    @ApiModelProperty("学时")
    private int trainsHour;

    @ApiModelProperty("特殊证书内容")
    private String special_content;

}
