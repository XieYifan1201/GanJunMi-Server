package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息VO
 * 返回给前端的用户信息数据
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户信息")
public class UserVO implements Serializable {
    
    /** 用户ID */
    @ApiModelProperty("用户ID")
    private Long id;
    
    /** 用户姓名 */
    @ApiModelProperty("用户姓名")
    private String name;
    
    /** 性别 */
    @ApiModelProperty("性别")
    private String sex;
    
    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;
    
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String idCard;
    
    /** 角色ID */
    @ApiModelProperty("角色ID")
    private Integer roleId;
    
    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    
    /** 头像路径 */
    @ApiModelProperty("头像路径")
    private String image;
}
