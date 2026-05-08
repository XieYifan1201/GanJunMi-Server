package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录DTO
 * 用于接收前端登录请求参数
 */
@Data
@ApiModel("用户登录请求参数")
public class UserLoginDTO implements Serializable {

    /** 微信授权码 */
    @ApiModelProperty("微信授权码")
    private String code;

    /** 登录账号 */
    @ApiModelProperty("账号")
    private String user;

    /** 登录密码 */
    @ApiModelProperty("密码")
    private String password;
}
