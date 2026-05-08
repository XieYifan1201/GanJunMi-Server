package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户授权DTO
 * 用于微信授权登录后的用户信息传输
 */
@Data
@ApiModel("用户授权信息")
public class UserAuthorizeDTO {

    /** 用户ID */
    @ApiModelProperty("用户id")
    private Long id;
    
    /** 用户角色ID */
    @ApiModelProperty("用户权限")
    private Integer roleId;
}
