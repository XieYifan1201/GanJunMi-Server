package com.train.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPageQueryDTO implements Serializable {

    //姓名
    private String name;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

}
