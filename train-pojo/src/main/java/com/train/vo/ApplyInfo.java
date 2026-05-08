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
 * 报名信息VO
 * 返回给前端的学员报名和培训信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("报名信息")
public class ApplyInfo {

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

    /** 报名记录ID */
    @ApiModelProperty("报名id")
    private int id;
    
    /** 是否已颁发证书 */
    @ApiModelProperty("是否颁发证书")
    private boolean isCertificate;
    
    /** 培训班标题 */
    @ApiModelProperty("培训班标题")
    private String trainsTitle;
    
    /** 开班期数 */
    @ApiModelProperty("开班期数")
    private String trainsName;
    
    /** 培训地址 */
    @ApiModelProperty("培训地址")
    private String trainsAddress;
    
    /** 培训班次名称 */
    @ApiModelProperty("培训班次")
    private String trainsClassName;
    
    /** 培训开始日期 */
    @ApiModelProperty("培训开始日期")
    private LocalDate startDate;
    
    /** 培训结束日期 */
    @ApiModelProperty("培训结束日期")
    private LocalDate endDate;
    
    /** 证书编号 */
    @ApiModelProperty("证书编号")
    private String CertificateNo;
    
    /** 培训地点 */
    @ApiModelProperty("培训地点")
    private String position;

    /** 报名日期 */
    @ApiModelProperty("报名日期")
    private LocalDateTime date;
    
    /** 是否已缴费 */
    @ApiModelProperty("是否缴费")
    private boolean pay;
}
