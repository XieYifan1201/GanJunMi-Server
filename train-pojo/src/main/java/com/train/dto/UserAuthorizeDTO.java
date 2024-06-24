package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAuthorizeDTO {

    @ApiModelProperty("用户id")
    private Long id;
    @ApiModelProperty("用户权限")
    private Integer roleId;

}
