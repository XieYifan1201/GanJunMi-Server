package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInvoicePageQueryDTO {

    private String name;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

    @ApiModelProperty("期数id")
    private int trainsId;

    @ApiModelProperty("发票状态 0所有 1有发票 2没有发票")
    private int state;


}
