package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学员发票分页查询DTO
 * 用于按条件分页查询学员发票信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("学员发票分页查询")
public class StudentInvoicePageQueryDTO {

    /** 学员姓名 */
    @ApiModelProperty("学员姓名")
    private String name;

    /** 页码 */
    @ApiModelProperty("页码")
    private Integer page;

    /** 每页显示记录数 */
    @ApiModelProperty("每页显示记录数")
    private Integer pageSize;

    /** 培训期次ID */
    @ApiModelProperty("期数id")
    private int trainsId;
    
    /** 培训班次ID */
    @ApiModelProperty("班次id")
    private int trainsClassId;

    /** 发票状态：0-所有，1-有发票，2-没有发票 */
    @ApiModelProperty("发票状态 0所有 1有发票 2没有发票")
    private int state;

    /** 缴费状态：0-所有，1-已缴费，2-未缴费 */
    @ApiModelProperty("缴费状态 0所有 1已缴费 2未缴费")
    private int payState;

    /** 是否倒序排列 */
    @ApiModelProperty("是否为倒序")
    private boolean reverse;
}
