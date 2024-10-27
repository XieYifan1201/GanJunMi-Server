package com.train.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentC {

    //学员信息和报名信息

    private Long id;
    private String name;
    private String sex;
    private String idCard;
    private String phone;
    @ApiModelProperty("担任职务")
    private String duties;
    @ApiModelProperty("工作单位")
    private String workUnit;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("区")
    private String district;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("学员开票信息id")
    private Integer invoiceId;
    @ApiModelProperty("图片路径")
    private String image;

    private Integer trainsClassId;
    private String trainsClassName;
    private Integer trainsId;
    private String trainsTitle;
    @ApiModelProperty("回执访问路径")
    private String receiptPath;



}
