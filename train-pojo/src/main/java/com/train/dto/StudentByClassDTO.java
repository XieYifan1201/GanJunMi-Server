package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentByClassDTO {
    private String name;

    private int trainsClassId;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

    @ApiModelProperty("0所有 1未获得 2获得")
    private int state;

}
