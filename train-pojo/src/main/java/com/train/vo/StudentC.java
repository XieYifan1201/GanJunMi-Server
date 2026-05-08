package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学员信息VO（包含报名信息）
 * 返回给前端的学员详细信息及报名相关数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员详细信息")
public class StudentC {

    /** 学员ID */
    @ApiModelProperty("学员ID")
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
    private Integer invoiceId;
    
    /** 图片路径 */
    @ApiModelProperty("图片路径")
    private String image;

    /** 培训班次ID */
    @ApiModelProperty("培训班次ID")
    private Integer trainsClassId;
    
    /** 培训班次名称 */
    @ApiModelProperty("培训班次名称")
    private String trainsClassName;
    
    /** 培训期次ID */
    @ApiModelProperty("培训期次ID")
    private Integer trainsId;
    
    /** 培训班标题 */
    @ApiModelProperty("培训班标题")
    private String trainsTitle;
    
    /** 回执文件访问路径 */
    @ApiModelProperty("回执访问路径")
    private String receiptPath;
}
