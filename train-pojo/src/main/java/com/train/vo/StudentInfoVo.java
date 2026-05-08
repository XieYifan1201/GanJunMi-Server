package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学员信息VO（包含发票信息）
 * 返回给前端的学员详细信息及发票相关数据
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员详细信息-含发票")
public class StudentInfoVo {

    /** 学员ID */
    @ApiModelProperty("学员id")
    private Long id;
    
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
    
    /** 开票信息ID */
    @ApiModelProperty("学员开票信息id")
    private int invoiceId;
    
    /** 图片路径 */
    @ApiModelProperty("图片路径")
    private String image;
    
    /** 发票抬头 */
    @ApiModelProperty("发票抬头")
    private String invoiceHead;
    
    /** 发票税号 */
    @ApiModelProperty("发票税号")
    private String invoiceNo;
    
    /** 开户银行 */
    @ApiModelProperty("开户银行")
    private String bankName;
    
    /** 银行账号 */
    @ApiModelProperty("银行账号")
    private String bangNo;
    
    /** 公司地址 */
    @ApiModelProperty("公司地址")
    private String unitAddress;
    
    /** 公司电话 */
    @ApiModelProperty("公司电话")
    private String unitPhone;
    
    /** 是否为增值税发票 */
    @ApiModelProperty("是否为增值税发票")
    private boolean isSpecial;
    
    /** 是否已缴费 */
    @ApiModelProperty("是否缴费")
    private boolean pay;
    
    /** 报名记录ID */
    @ApiModelProperty("报名id")
    private int studentCertificateId;
    
    /** 回执文件路径 */
    @ApiModelProperty("回执")
    private String receiptPath;

    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private Integer trainsClassId;
    
    /** 培训班次名称 */
    @ApiModelProperty("班次名称")
    private String trainsClassName;
    
    /** 培训期次ID */
    @ApiModelProperty("期数id")
    private Integer trainsId;
    
    /** 培训班标题 */
    @ApiModelProperty("期数名称")
    private String trainsTitle;
}
