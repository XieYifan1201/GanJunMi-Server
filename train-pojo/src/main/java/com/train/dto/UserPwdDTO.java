package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户密码修改DTO
 * 用于接收修改密码请求参数
 */
@Data
@ApiModel("用户密码修改请求参数")
public class UserPwdDTO {

    /** 用户ID */
    @ApiModelProperty("用户ID")
    Long id;
    
    /** 新密码 */
    @ApiModelProperty("新密码")
    String password;
}
