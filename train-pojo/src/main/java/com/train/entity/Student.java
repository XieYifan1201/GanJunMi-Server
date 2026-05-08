package com.train.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学员实体类
 * 对应数据库 student 表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    /** 学员ID */
    private Long id;
    
    /** 学员姓名 */
    private String name;
    
    /** 性别 */
    private String sex;
    
    /** 身份证号 */
    private String idCard;
    
    /** 联系电话 */
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
}
