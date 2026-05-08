package com.train.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 草稿箱获取DTO
 * 用于获取微信公众号草稿箱中的单篇文章
 */
@Data
@ApiModel("草稿箱获取请求参数")
public class DraftGetDTO {
    
    /** 草稿ID */
    @ApiModelProperty("草稿ID")
    private String id;
}
