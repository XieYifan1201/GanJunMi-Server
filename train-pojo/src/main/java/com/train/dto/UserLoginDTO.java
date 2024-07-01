package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * C端用户登录
 */
@Data
public class UserLoginDTO implements Serializable {

    @ApiModelProperty("微信授权码")
    private String code;

    @ApiModelProperty("账号")
    private String user;

    @ApiModelProperty("密码")
    private String password;

}
