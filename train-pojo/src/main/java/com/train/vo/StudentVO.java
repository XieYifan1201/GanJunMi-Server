package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学员信息VO
 * 返回给前端的学员信息数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员信息")
public class StudentVO {

    /** 学员报名记录ID */
    @ApiModelProperty("学员报名id")
    private int studentCertificateId;
    
    /** 学员ID */
    @ApiModelProperty("学员id")
    private Long studentId;
    
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
    
    /** 图片路径 */
    @ApiModelProperty("图片路径")
    private String image;
    
    /** 是否已颁发证书 */
    @ApiModelProperty("是否颁发证书")
    private boolean isCertificate;
    
    /** 特殊证书信息 */
    @ApiModelProperty("特殊证书信息")
    private String special_content;

    /** 报名日期 */
    @ApiModelProperty("报名日期")
    private LocalDateTime date;
    
    /** 是否已缴费 */
    @ApiModelProperty("是否缴费")
    private boolean pay;
}
