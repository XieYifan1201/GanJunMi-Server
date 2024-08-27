package com.train.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 基本的分页查询DTO
 */
@Data
public class PageQueryDTO implements Serializable {

    private String name;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;

}
