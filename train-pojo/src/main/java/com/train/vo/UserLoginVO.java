package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户登录VO
 * 登录成功后返回给前端的数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户登录响应数据")
public class UserLoginVO implements Serializable {

    /** JWT令牌 */
    @ApiModelProperty("JWT令牌")
    private String token;
    
    /** 角色ID */
    @ApiModelProperty("角色ID")
    private Integer roleId;
    
    /** 用户姓名 */
    @ApiModelProperty("用户姓名")
    private String name;
    
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String idCard;
    
    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;
    
    /** 性别 */
    @ApiModelProperty("性别")
    private String sex;
    
    /** 头像路径 */
    @ApiModelProperty("头像路径")
    private String image;
    
    /** 用户ID */
    @ApiModelProperty("用户ID")
    private Long id;
}
