package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 学员分页查询DTO
 * 用于接收学员分页查询请求参数
 */
@Data
@ApiModel("学员分页查询请求参数")
public class StudentPageQueryDTO implements Serializable {

    /** 培训期次ID */
    @ApiModelProperty("期数id")
    private int trainsId;
    
    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private int trainsClassId;
    
    /** 学员姓名 */
    @ApiModelProperty("学员姓名")
    private String name;
    
    /** 身份证号 */
    @ApiModelProperty("身份证号")
    private String idCard;
    
    /** 性别 */
    @ApiModelProperty("性别")
    private String sex;
    
    /** 工作单位 */
    @ApiModelProperty("工作单位")
    private String workUnit;
    
    /** 是否倒序排列 */
    @ApiModelProperty("是否为倒序")
    private boolean reverse;

    /** 单位排序方式 */
    @ApiModelProperty("单位排序")
    private boolean unitReverse;

    /** 所在城市 */
    @ApiModelProperty("市")
    private String city;

    /** 页码 */
    @ApiModelProperty("页码")
    private Integer page;

    /** 每页显示记录数 */
    @ApiModelProperty("每页显示记录数")
    private Integer pageSize;
}
