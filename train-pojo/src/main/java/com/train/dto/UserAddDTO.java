package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户添加DTO
 * 用于接收添加用户请求参数
 */
@Data
@ApiModel("用户添加请求参数")
public class UserAddDTO {

    /** 微信OpenID */
    @ApiModelProperty("登录账号")
    private String openid;
    
    /** 用户姓名 */
    @ApiModelProperty("使用者姓名")
    private String name;
    
    /** 性别 */
    @ApiModelProperty("男/女")
    private String sex;
    
    /** 角色ID：1-系统管理员，2-管理员 */
    @ApiModelProperty("添加管理员级别 1系统管理员 2管理员")
    private Integer roleId;
    
    /** 联系电话 */
    private String phone;
    
    /** 身份证号 */
    private String idCard;
}
