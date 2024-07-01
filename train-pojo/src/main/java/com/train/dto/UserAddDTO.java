package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAddDTO {

    @ApiModelProperty("登录账号")
    private String openid;
    @ApiModelProperty("使用者姓名")
    private String name;
    @ApiModelProperty("登录密码")
    private String password;
    @ApiModelProperty("男/女")
    private String sex;
    @ApiModelProperty("添加管理员级别 1系统管理员 2管理员")
    private Integer roleId;
    private String phone;
    private String idCard;

}
