package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 基本的分页查询DTO
 */
@Data
public class StudentPageQueryDTO implements Serializable {

    @ApiModelProperty("期数id")
    private int trainsId;
    private String name;
    private String idCard;
    private String sex;
    @ApiModelProperty("工作单位")
    private String workUnit;
    @ApiModelProperty("是否为倒序")
    private boolean reverse;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

}
