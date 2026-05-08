package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户信息DTO
 * 用于用户信息传输
 */
@Data
@ApiModel("用户信息")
public class UserDTO {

    /** 用户ID */
    @ApiModelProperty("用户ID")
    private Long id;
    
    /** 用户姓名 */
    @ApiModelProperty("用户姓名")
    private String name;
    
    /** 登录密码 */
    @ApiModelProperty("密码")
    private String password;
    
    /** 性别 */
    @ApiModelProperty("性别")
    private String sex;
    
    /** 联系电话 */
    @ApiModelProperty("联系电话")
    private String phone;
    
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String idCard;
    
    /** 头像图片路径 */
    @ApiModelProperty("头像")
    private String image;
}
