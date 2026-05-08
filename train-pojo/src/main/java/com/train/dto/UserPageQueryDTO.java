package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户分页查询DTO
 * 用于接收用户分页查询请求参数
 */
@Data
@ApiModel("用户分页查询请求参数")
public class UserPageQueryDTO implements Serializable {

    /** 用户姓名 */
    @ApiModelProperty("用户姓名")
    private String name;

    /** 页码 */
    @ApiModelProperty("页码")
    private Integer page;

    /** 每页显示记录数 */
    @ApiModelProperty("每页显示记录数")
    private Integer pageSize;
}
