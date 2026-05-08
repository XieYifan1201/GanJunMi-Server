package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章删除DTO
 * 用于接收文章删除请求参数
 */
@Data
@ApiModel("文章删除请求参数")
public class ArticleDelDTO {

    /** 文章ID */
    @ApiModelProperty("文章ID")
    private String article_id;
    
    /** 文章索引 */
    @ApiModelProperty("文章索引")
    private int index;
}
