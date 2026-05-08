package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 报名信息VO
 * 返回给前端的学员报名详细信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("报名信息")
public class SignVO {

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
    
    /** 报名信息列表 */
    @ApiModelProperty("报名信息列表")
    private List<SignInfo> signInfos;
}
