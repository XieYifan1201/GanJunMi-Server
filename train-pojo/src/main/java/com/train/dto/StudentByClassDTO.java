package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 按班级查询学员DTO
 * 用于按培训班次查询学员信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("按班级查询学员")
public class StudentByClassDTO {
    
    /** 学员姓名 */
    @ApiModelProperty("学员姓名")
    private String name;

    /** 培训班次ID */
    @ApiModelProperty("培训班次ID")
    private int trainsClassId;

    /** 页码 */
    @ApiModelProperty("页码")
    private Integer page;

    /** 每页显示记录数 */
    @ApiModelProperty("每页显示记录数")
    private Integer pageSize;

    /** 查询状态：0-所有，1-未获得证书，2-已获得证书 */
    @ApiModelProperty("0所有 1未获得 2获得")
    private int state;
}
