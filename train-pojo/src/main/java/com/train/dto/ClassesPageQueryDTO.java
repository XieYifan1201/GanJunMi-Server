package com.train.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClassesPageQueryDTO {

    private String name;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

    @ApiModelProperty("1 查询所有培训期次信息 0 查询开启报名的培训信息")
    private int state;

}
