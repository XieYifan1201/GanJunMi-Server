package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 证书信息VO
 * 返回给前端的证书详细信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("证书信息")
public class CertificateVO {

    /** 证书编号 */
    @ApiModelProperty("证书编号")
    private String CertificateNo;
    
    /** 证书标题 */
    @ApiModelProperty("证书标题")
    private String title;
    
    /** 证书有效开始日期 */
    @ApiModelProperty("证书有效开始日期")
    private LocalDate startDate;
    
    /** 证书有效年限 */
    @ApiModelProperty("证书有效年限")
    private String deadline;
    
    /** 颁证单位 */
    @ApiModelProperty("颁证单位")
    private String trainUnit;
    
    /** 证书获得人姓名 */
    @ApiModelProperty("证书获得人")
    private String name;
    
    /** 证书二维码 */
    @ApiModelProperty("证书二维码")
    private String QRcode;
    
    /** 证件照片 */
    @ApiModelProperty("照片")
    private String image;
    
    /** 培训开始日期 */
    @ApiModelProperty("培训开始日期")
    private LocalDate trainStartDate;
    
    /** 培训结束日期 */
    @ApiModelProperty("培训结束日期")
    private LocalDate trainEndDate;
    
    /** 培训班名称 */
    @ApiModelProperty("培训班名称")
    private String trainsTitle;
    
    /** 学时 */
    @ApiModelProperty("学时")
    private int trainsHour;

    /** 特殊证书内容 */
    @ApiModelProperty("特殊证书内容")
    private String special_content;
}
