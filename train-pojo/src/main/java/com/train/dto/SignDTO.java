package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学员报名DTO
 * 用于接收学员报名信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员报名信息")
public class SignDTO {

    /** 培训期次ID */
    @ApiModelProperty("培训期次id")
    private Integer trainsId;
    
    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private Integer trainClassId;
    
    /** 学员姓名 */
    @ApiModelProperty("学员姓名")
    private String name;
    
    /** 性别 */
    @ApiModelProperty("性别")
    private String sex;
    
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String idCard;
    
    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;
    
    /** 担任职务 */
    @ApiModelProperty("担任职务")
    private String duties;
    
    /** 工作单位 */
    @ApiModelProperty("工作单位")
    private String workUnit;
    
    /** 所在城市 */
    @ApiModelProperty("市")
    private String city;
    
    /** 所在区县 */
    @ApiModelProperty("区")
    private String district;
    
    /** 详细地址 */
    @ApiModelProperty("详细地址")
    private String address;
    
    /** 学员开票信息ID */
    @ApiModelProperty("学员开票信息id")
    private Integer invoiceId;
    
    /** 图片路径 */
    @ApiModelProperty("图片路径")
    private String image;
    
    /** 回执路径 */
    @ApiModelProperty("回执路径")
    private String receiptPath;
}
