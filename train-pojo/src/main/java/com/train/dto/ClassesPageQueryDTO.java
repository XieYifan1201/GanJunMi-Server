package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 培训班次分页查询DTO
 * 用于接收培训班次分页查询请求参数
 */
@Data
@ApiModel("培训班次分页查询请求参数")
public class ClassesPageQueryDTO {

    /** 班次名称 */
    @ApiModelProperty("班次名称")
    private String name;

    /** 页码 */
    @ApiModelProperty("页码")
    private Integer page;

    /** 每页显示记录数 */
    @ApiModelProperty("每页显示记录数")
    private Integer pageSize;

    /** 查询状态：1-查询所有培训期次信息，0-查询开启报名的培训信息 */
    @ApiModelProperty("1 查询所有培训期次信息 0 查询开启报名的培训信息")
    private int state;
}
